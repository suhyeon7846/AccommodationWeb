package com.teum.controller.user.qna;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teum.entity.QnA;
import com.teum.service.QnAService;

@WebServlet("/user/qna")
public class ListController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//session 사용 
		HttpSession session = request.getSession();	
		//session에 email이 null이면 로그인 페이지로 간다.
		if(session.getAttribute("email")==null) {
			response.sendRedirect("/signin?return-url=/user/qna");
		}
		//session에 type이 0(일반 사용자)이 아니면 메인 페이지로 보낸다.
		else if(((int)session.getAttribute("type")) != 0) {
			response.sendRedirect("/index");
		}
		else {
			//session에 저장된 id값을 가져온다.	
			int id = (int)session.getAttribute("id");


			//문의사항 서비스 객체를 만든다.
			QnAService service = new QnAService();
			//id 값에 해당하는 문의사항 목록을 list에 넣는다.
			List<QnA> list = service.getList(id);
			
			//"list"이름으로 list를 request에 저장
			request.setAttribute("list",list);
			//"qna.jsp"로 request와 response를 전달한다.
			request.getRequestDispatcher("qna.jsp").forward(request, response);
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//session 사용 
		HttpSession session = request.getSession();	
		//session에 저장된 id값을 가져온다.	
		int id = (int)session.getAttribute("id");
		//"category,title,content" 각 파라미터 값을 가져온다.
		int category = Integer.parseInt( request.getParameter("category"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		//문의사항 서비스 객체를 생성한다.
		QnAService service = new QnAService();
		
		//문의사항 객체를 생성하고. "id, category, title, content" 값을 바꿔준다.
		QnA qna = new QnA();
		qna.setUserId(id);
		qna.setCategoryId(category);
		qna.setTitle(title);
		qna.setContent(content);

		//qna 객체를 넘기고 DB에 insert한다.
		service.insert(qna);

		//"qna" page를 로드한다.
		response.sendRedirect("qna");
	}
}
