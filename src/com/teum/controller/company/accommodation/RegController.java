package com.teum.controller.company.accommodation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.teum.entity.Acc;
import com.teum.entity.Room;
import com.teum.entity.RoomImage;
import com.teum.service.AccService;
import com.teum.service.RoomImageService;
import com.teum.service.RoomService;

@WebServlet("/company/accommodation/reg")
@MultipartConfig( 
	    fileSizeThreshold = 1024*1024, 
	    maxFileSize = 1024*1024*10, 
	    maxRequestSize = 1024*1024*10*10)
public class RegController extends HttpServlet {

	private AccService accService;
	private RoomService roomService;
	private RoomImageService roomImageService;
	
	public RegController() {
		accService = new AccService();
		roomService = new RoomService();
		roomImageService = new RoomImageService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		request.getRequestDispatcher("reg.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		// 숙소 데이터
		String accName = request.getParameter("acc-name");
		String phone = request.getParameter("phone");
		String bigLocation = request.getParameter("big-location");
		String smallLocation = request.getParameter("small-location");
		String detailAddress = request.getParameter("detail-address");
		String accType = request.getParameter("acc-type");
		String fullAddress = bigLocation + " " + smallLocation + " " + detailAddress;
		
		int accTypeNum = 0;
		switch (accType) {
		case "호텔":
			accTypeNum = 1;
			break;
			
		case "모텔":
			accTypeNum = 2;
			break;
		
		case "게스트하우스":
			accTypeNum = 3;
			break;
			
		case "리조트":
			accTypeNum = 4;
			break;
			
		case "펜션":
			accTypeNum = 5;
			break;
		}
		
		// 방 데이터
		String roomName = request.getParameter("room-name");
		String roomCount_ = request.getParameter("room-count");
		String maxHeadcount_ = request.getParameter("max-headcount");
		String bedCount_ = request.getParameter("bed-count");
		String price_ = request.getParameter("price");
		
		int roomCount = 0;
		int maxHeadcount = 0;
		int bedCount = 0;
		int price = 0;
		
		if (roomCount_ != null && !roomCount_.equals(""))
			roomCount = Integer.parseInt(roomCount_);
		
		if (maxHeadcount_ != null && !maxHeadcount_.equals(""))
			maxHeadcount = Integer.parseInt(maxHeadcount_);
		
		if (bedCount_ != null && !bedCount_.equals(""))
			bedCount = Integer.parseInt(bedCount_);
		
		if (price_ != null && !price_.equals(""))
			price = Integer.parseInt(price_);
		
		// 숙소, 방 사진 데이터
		Collection<Part> fileParts = request.getParts();
		String fileName = null;
		String filePath = null;
		StringBuilder builder = new StringBuilder();
		
		// 파일 다중 업로드
		for (Part p : fileParts) {
			if (p.getName().equals("file") && p.getSize() > 0) {
				// 만약 처음으로 등록하는 글이라면? 일단 수동으로 한 개의 이벤트는 넣는 것으로 패스
				
				// 현재 게시글에 들어가 있는 번호중에서 마지막 번호를 동적으로 알아내기
				int newId = accService.getLastId() + 1;
				
				String pathTemp = request.getServletContext().getRealPath("/images/company/accommodation/2020/" + newId); 
				
				File path = new File(pathTemp); // 얘는 절대경로만 받는다.
				if (!path.exists())
					path.mkdirs();
				
				fileName = p.getSubmittedFileName();
				filePath = pathTemp + File.separator + fileName;
				builder.append(fileName);
				builder.append(",");
				
				InputStream fis = p.getInputStream();
				FileOutputStream fos = new FileOutputStream(filePath);
				
				byte[] buf = new byte[1024];
				int size = 0;
				
				while((size = fis.read(buf)) != -1)
					fos.write(buf, 0, size);
				
				fos.close();
				fis.close();
				
				System.out.printf("filename: %s, filepath: %s", fileName, filePath);
			}
		}
		builder.delete(builder.length() - 1, builder.length());
		
		System.out.printf("accName: %s\n", accName);
		System.out.printf("phone: %s\n", phone);
		System.out.printf("location: %s\n", fullAddress);
		System.out.printf("accTypeId: %d\n", accTypeNum);
		System.out.printf("companyId: %d\n", (int)session.getAttribute("id"));
		System.out.printf("adminId: %d\n", 1);
		Acc acc = new Acc();
		acc.setName(accName);
		acc.setPhone(phone);
		acc.setLocation(fullAddress);
		acc.setAccTypeId(accTypeNum);
		acc.setCompanyId((int)session.getAttribute("id"));
		acc.setAdminId(1);
		
		accService.insert(acc); // insert를 하고 난 후에 방금 넣은 acc의 id값 받아오기

		int accId = accService.getLastId();

		Room room = new Room();
		room.setAccId(accId);
		room.setName(roomName);
		room.setPrice(price);
		room.setMaxHeadcount(maxHeadcount);
		room.setBedCount(bedCount);

		roomService.insert(room);

		RoomImage roomImage = new RoomImage();

		int roomId = roomService.getLastId(); // insert를 하고 난 후에 방금 넣은 room의 id값 받아오기

		roomImage.setRoomId(roomId);
		roomImage.setFilename(fileName);
		roomImage.setFileroute(filePath);

		roomImageService.insert(roomImage);

		response.sendRedirect("/index");
	}
	
}