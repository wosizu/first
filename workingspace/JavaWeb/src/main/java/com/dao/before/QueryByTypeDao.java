package com.dao.before;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Goods;

public interface QueryByTypeDao {
	public List<Goods> query(@Param("typeId")int typeId,@Param("nonius") int nonius);
}
