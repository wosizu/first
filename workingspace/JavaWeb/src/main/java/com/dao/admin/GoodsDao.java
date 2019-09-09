package com.dao.admin;

import java.util.List;

import com.entity.Auser;
import com.entity.Goods;

public interface GoodsDao {
	public Goods queryGoods(int id);
	public int addGoods(Goods goods);
	public int deleteGoods(int id);
	public int updateGoods(Goods goods);
	
}
