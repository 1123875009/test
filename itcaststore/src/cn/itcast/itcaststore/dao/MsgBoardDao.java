package cn.itcast.itcaststore.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.itcaststore.domain.Msgboard;
import cn.itcast.itcaststore.domain.Notice;
import cn.itcast.itcaststore.domain.User;
import cn.itcast.itcaststore.utils.DataSourceUtils;

public class MsgBoardDao {
public List<Msgboard> queryMsgboard() throws SQLException {
	String sql="select * from msgboard where status=1 order by msgdate";
	QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
	return runner.query(sql, new BeanListHandler<Msgboard>(Msgboard.class));
}
public int UpdateMsgboard(Msgboard msgboard) throws SQLException {
	String sql="update msgboard set status=0,msgreply=? where msg_id=?";
	QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
	return runner.update(sql,msgboard.getMsgreply(),msgboard.getMsg_id());
}
public int addMsgboard(Msgboard msgboard) throws SQLException {
	String sql="insert into msgboard(username,msgdate,msgcontent) values"
			+ " (?,curdate(),?)";
	QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
	return runner.update(sql,msgboard.getUsername(),msgboard.getMsgcontent());
	//return runner.update(sql,msgboard.getUser().getUsername(),msgboard.getMsgcontent());
}
public List<Msgboard> queryMsgboard(String name) throws SQLException {
	String sql="select * from msgboard where username=? order by msgdate desc limit 5";
	QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
	return runner.query(sql, new BeanListHandler<Msgboard>(Msgboard.class),name);
}

}
