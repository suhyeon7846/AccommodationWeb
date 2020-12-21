package com.teum.service;

import java.util.List;

import com.teum.dao.RoomDao;
import com.teum.dao.entity.OfferInfoView;
import com.teum.dao.entity.OfferableRoomListView;
import com.teum.dao.entity.PayInfoView;
import com.teum.dao.jdbc.JdbcRoomDao;
import com.teum.entity.Room;

public class RoomService implements RoomServiceI {

	private RoomDao roomDao;

	public RoomService() {
		roomDao = new JdbcRoomDao();
	}

	public int insert(Room room) {
		int result = roomDao.insert(room);
		return result;
	}

	public int getLastId() {
		Room room = roomDao.getLast();
		return room.getId();
	}

	@Override
	public List<Room> getList(String accIdsCSV) {
		return roomDao.getList(accIdsCSV);
	}

	@Override
	public List<OfferInfoView> getOfferInfoList(int page, int offerId) {
		int startIndex = 1 + (page - 1) * 3;
		int endIndex = page * 3;
		return roomDao.getOfferInfoList(startIndex, endIndex, offerId);
	}

	public List<OfferableRoomListView> getOfferableRoomList(int offerId) {
//		int startIndex = 1 + (page - 1) * 3;
//		int endIndex = page * 3;
//		return roomDao.getOfferableRoomList(startIndex, endIndex, offerId);
		return roomDao.getOfferableRoomList(offerId);
	}

	@Override
	public int getOfferCount(int offerId) {
		int result=0;
		
		result = roomDao.getOfferCount(offerId);
		// TODO Auto-generated method stub
		return result;
	}

	public int getId(int roomId) {
		return roomDao.getId(roomId);
	}

	public Room get(int roomId) {
		return roomDao.get(roomId);
	}

	public List<Room> getList(int accId) {
		return roomDao.getList(accId);
	}

	public PayInfoView getList(int accId, int roomId) {
		return roomDao.getList(accId, roomId);
	}

	public int update(int accId, int roomId, String bookedDates) {
		return roomDao.update(accId, roomId, bookedDates);
	}
}
