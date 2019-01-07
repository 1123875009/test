package cn.itcast.itcaststore.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.itcaststore.domain.Collection;
import cn.itcast.itcaststore.domain.Notice;
import cn.itcast.itcaststore.utils.DataSourceUtils;

public class CollectionDao {
	//添加收藏
	public void addCollection(Collection c) throws SQLException {//公告的id为自增，所以不需要表明字段名
		String sql = "insert into collection(user_id,product_id) values(?,?)";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql, c.getUser_id(),c.getProduct_id());
	}

}
