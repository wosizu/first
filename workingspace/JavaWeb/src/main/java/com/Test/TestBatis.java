package com.Test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.entity.Goods;

public class TestBatis {

	public void main() throws Exception {
		
		String resource="../mybatis/mybatis-config.xml";
        InputStream resourceAsStream = TestBatis.class.getResourceAsStream(resource);       
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession session=sqlSessionFactory.openSession();

         Goods goods = session.selectOne("com.dao.AdminGoodsDao.findById", 1);

	}
}


