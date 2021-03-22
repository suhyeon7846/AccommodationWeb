package com.teum.controller.admin.customerservice.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.entity.Notice;
import com.teum.service.NoticeService;



@WebServlet("/admin/customerService/notice/del")
public class DeleteController extends HttpServlet{
	
	@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//id값 가져온다.
		int id = Integer.parseInt(request.getParameter("id"));
		//공지사항 서비스 객체 생성
		NoticeService service = new NoticeService();
		
		//id값에 맞는 데이타를 지운다.
		service.delete(id);
		
		//"list" page를 로딩 
		response.sendRedirect("list");
		
		}
	

}
