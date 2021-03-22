package com.teum.controller.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.entity.Notice;
import com.teum.service.NoticeService;
@WebServlet("/notice/list")
public class ListController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지사항 서비스 객체 생성한다.
		NoticeService service = new NoticeService();
		//공지사항 목록을 불러와서 list에 넣는다.
		List<Notice> list = service.getUserList();
		
		//"list"라는 이름으로 위 목록 리스트를 request에 저장한다.
		request.setAttribute("list", list);
		//"list.jsp"로 request와 response를 전달한다.
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
}
