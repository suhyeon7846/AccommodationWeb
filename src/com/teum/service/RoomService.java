package com.teum.service;

import java.util.List;

import com.teum.dao.RoomDao;
import com.teum.dao.jdbc.JdbcRoomDao;
import com.teum.entity.Room;

public class RoomService {
	
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

	public List<Room> getList(String accIdsCSV) {
		return roomDao.getList(accIdsCSV);
	}
}
