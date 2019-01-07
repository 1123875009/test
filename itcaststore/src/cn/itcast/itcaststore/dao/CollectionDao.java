package cn.itcast.itcaststore.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import cn.itcast.itcaststore.domain.Collection;
import cn.itcast.itcaststore.domain.Notice;
import cn.itcast.itcaststore.utils.DataSourceUtils;
import cn.itcast.itcaststore.utils.IdUtils;

public class CollectionDao {
	//添加收藏
	public void addCollection(Collection c) throws SQLException {//公告的id为自增，所以不需要表明字段名
		String sql = "insert into collection(id,user_id,product_id) values(?,?,?)";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql,IdUtils.getUUID(),c.getUser_id(),c.getProduct_id());
	}
	public List<Object[]> getCollections(int user_id) throws SQLException {
		String sql = "SELECT distinct name,imgurl,"+
                             "price,product_id"+
                     " FROM collection,user,products"+
                     " WHERE products.id=collection.product_id"+
                             " AND collection.user_id=user.id"+
                             " AND collection.user_id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new ArrayListHandler(),user_id);
	}
	public void delCollectionById(String id) throws SQLException {
		String sql="delete from collection where id=?";
		
		QueryRunner runner=new QueryRunner();
		
		runner.update(DataSourceUtils.getConnection(),sql,id);
	}


}
