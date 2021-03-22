package com.teum.controller.admin.customerservice.notice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.teum.entity.Notice;
import com.teum.service.NoticeService;



@WebServlet("/admin/customerService/notice/edit")
@MultipartConfig(
		fileSizeThreshold=1024*1024, 
	    maxFileSize=1024*1024*5, 
	    maxRequestSize=1024*1024*5*5)
public class EditController extends HttpServlet{
	
	private NoticeService service = new NoticeService();
	
	public EditController() {
		service = new NoticeService();
	}
	
	@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//id 가져오기
		int id = Integer.parseInt(request.getParameter("id"));
	//NoticeService service = new NoticeService();
		//id에 맞는 공지사항 Notice 객체에 넣기
		Notice n = service.get(id); 
		
		request.setAttribute("n", n);
		request.getRequestDispatcher("edit.jsp").forward(request,response);
		
		}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//"id, title, content, admin_id, open_status, image_name" 값 가져오기
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 내려쓰기 적용
		content = content.replace("\r\n", "<br >");
		
		int adminId = Integer.parseInt(request.getParameter("ADMIN_ID"));
		String open =request.getParameter("OPEN_STATUS");
		Part file = request.getPart("IMAGE_NAME");
		
		// "open" 값을 1,0 으로 바꾸기
		if(open!=null) {
			open ="1";
		}else {
			open="0";
		}
		
		int openStatus = Integer.parseInt(open);
		
		//------------------------------------------------------------------------
		//notice 객체 생성
		Notice notice = new Notice(title,content,adminId,openStatus);
		notice.setId(Integer.parseInt(id));
		
		//물리경로에 이미지 파일 생성하기
		if(file !=null && file.getSize()>0) {
			String fileName = file.getSubmittedFileName();
			notice.setImageName(fileName);
			
			String pathTemp = request.getServletContext().getRealPath("/images/notice/2020/"+id);
			
			File path = new File(pathTemp);
			if(!path.exists())
				path.mkdirs();
			
			String filePath = pathTemp+File.separator+fileName;
			
			InputStream fis = file.getInputStream();
			FileOutputStream fos = new FileOutputStream(filePath);
			
			byte[] buf = new byte[1024];
			int size= 0;
			while((size = fis.read(buf)) != -1)
				fos.write(buf, 0,size);
				
			fos.close();
			fis.close();
		}
		
		//DB에 수정한 공지사항 update
		service.update(notice);
		
		response.sendRedirect("detail?id="+id);
	}

}
