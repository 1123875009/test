package cn.itcast.itcaststore.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.itcaststore.dao.CollectionDao;
import cn.itcast.itcaststore.domain.Collection;
import cn.itcast.itcaststore.domain.Notice;
import cn.itcast.itcaststore.domain.Order;
import cn.itcast.itcaststore.domain.OrderItem;
import cn.itcast.itcaststore.utils.DataSourceUtils;

public class CollectionService {
	CollectionDao dao=new CollectionDao();
	//后台系统，添加收藏
	public void addCollection(Collection c) {
		try {
			DataSourceUtils.startTransaction();//开启事务
			dao.addCollection(c);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				DataSourceUtils.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}finally{
			try {
				DataSourceUtils.releaseAndCloseConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	
	public List<Object[]> getCollections(int user_id) {
		try {
			return dao.getCollections(user_id);
		} catch (Exception e) {
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
	
	public boolean findCollection(int uid,String pid){
		try {
			Collection collect = dao.findCollection(uid,pid);
			if(collect==null){
				return false;
			}else{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;	
	}
	
}