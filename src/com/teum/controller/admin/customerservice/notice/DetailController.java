package com.teum.controller.admin.customerservice.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teum.entity.Notice;
import com.teum.service.NoticeService;



@WebServlet("/admin/customerService/notice/detail")
public class DetailController extends HttpServlet{
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// id 값 가져온다.
	int id = Integer.parseInt(request.getParameter("id"));
	
	//공지사항 서비스 객체 생성
	NoticeService service = new NoticeService();
	
	//id에 맞는 공지사항 Notice 객체에 담기.
	Notice n = service.get(id);
	
	request.setAttribute("n", n);
	request.getRequestDispatcher("detail.jsp").forward(request,response);
}
}
