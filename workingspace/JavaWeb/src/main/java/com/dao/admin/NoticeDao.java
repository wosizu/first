package com.dao.admin;

import com.entity.Notice;

public interface NoticeDao {
	public int addNotice(Notice notice);
	public int deleteNotice(int id);
	public int updateNotice(Notice notice);
	public Notice queryNotice(int id);
}
