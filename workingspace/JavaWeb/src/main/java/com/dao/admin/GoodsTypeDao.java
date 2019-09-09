package com.dao.admin;

import com.entity.GoodsType;

public interface GoodsTypeDao {
	public int addType(GoodsType type);
	public int deleteType(int id);
	public int updateType(GoodsType type);
	public GoodsType queryType(int id);
}
