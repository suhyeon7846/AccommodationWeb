package com.teum.controller.admin.customerservice.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.entity.Notice;
import com.teum.service.NoticeService;



@WebServlet("/admin/customerService/notice/edit")
public class EditController extends HttpServlet{
	
	@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		NoticeService service = new NoticeService();
		Notice n = service.get(id);
		/*
		 * Notice n = service.get(id); String pub = ""; if(n.getOpenStatus()=='1') {
		 * 
		 * pub="checked"; }else pub=null;
		 */
		request.setAttribute("n", n);
		request.getRequestDispatcher("edit.jsp").forward(request,response);
		
		}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String open =request.getParameter("OPEN_STATUS");
		
		System.out.println(open);
		/*if(open.equals("on")) {
			open ="1";
		}else {
			open="0";
		}
		*/
		//int openStatus = Integer.parseInt(open);
		
		/* Notice notice = new Notice(title,content,openStatus); */
		Notice notice = new Notice(title,content);
		notice.setId(Integer.parseInt(id));
		
		NoticeService service = new NoticeService();
		service.update(notice);
		
		response.sendRedirect("detail?id="+id);
	}

}
