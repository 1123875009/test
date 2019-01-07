package cn.itcast.itcaststore.service;

import java.sql.SQLException;

import cn.itcast.itcaststore.dao.CollectionDao;
import cn.itcast.itcaststore.domain.Collection;
import cn.itcast.itcaststore.domain.Notice;

public class CollectionService {
	CollectionDao dao=new CollectionDao();
	//后台系统，添加收藏
	public void addCollection(Collection c) {
		try {
			dao.addCollection(c);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加收藏失败!");
		}
	}

}
