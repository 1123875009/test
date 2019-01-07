package cn.itcast.itcaststore.service;

import java.sql.SQLException;
import java.util.List;

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
	public List<Object[]> getCollections(int user_id) {
		try {
			return dao.getCollections(user_id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("前台获取收藏商品失败！");
		}
	}
	public void delConnectionById(String id){
		try {
			dao.delCollectionById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
