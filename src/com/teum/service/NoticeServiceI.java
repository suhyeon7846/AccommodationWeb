package com.teum.service;

import java.util.List;

import com.teum.dao.entity.NoticeView;
import com.teum.entity.Notice;

public interface NoticeServiceI {

	List<Notice> getList(int page,String query);
	
	List<NoticeView> getViewList(int page,String query);
	
	Notice get(int id);
	
	Notice getLast();

	int getCount(String query);
	
	int openAll(String oIdsCSV, String cIdsCSV);
	
	int closeAll(String oIdsCSV, String cIdsCSV);
	
	int deleteAll(int[] ids);
	
	int update(int id);
	
	int delete(int id);
	
	int insert(Notice notice);
	
}
