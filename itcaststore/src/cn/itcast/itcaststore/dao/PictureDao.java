package cn.itcast.itcaststore.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.itcaststore.domain.Notice;
import cn.itcast.itcaststore.domain.Picture;
import cn.itcast.itcaststore.utils.DataSourceUtils;
import cn.itcast.itcaststore.utils.IdUtils;

public class PictureDao {
	//前台显示5张图片
	public List<Picture> showPictures() throws SQLException {
		String sql = "select * from picture order by time desc limit 0,5";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanListHandler<Picture>(Picture.class));
	}   //返回bean列表
	
	
	
	//后台显示全部图片可以修改
	public List<Picture> getAllPictures() throws SQLException {
		String sql = "select * from picture";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanListHandler<Picture>(Picture.class));
	}   //返回bean列表
	
	
	
	//后台系统，添加图片
	public void addPicture(Picture p) throws SQLException {
		String sql = "insert into picture(id,tile,time,imgurl) values(?,?,?,?)";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql,p.getId(),p.getTitle(),p.getTime(),p.getImgurl());
	}

	//后台系统，根据id查找图片
	public Picture findPictureById(String id) throws SQLException {
		String sql = "select * from picture where id = ?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanHandler<Picture>(Picture.class),id);
	}     

	//后台系统，根据id修改单个图片
	public void updatePicture(Picture p) throws SQLException {
		String sql = "update picture set title=?,time=?,imgurl=? where id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql, p.getTitle(),p.getTime(),p.getImgurl(),p.getId());
	}

	//后台系统，根据id删除图片
	public void deletePicture(String id) throws SQLException {
		String sql = "delete from picture where id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql, id);
	}

}
