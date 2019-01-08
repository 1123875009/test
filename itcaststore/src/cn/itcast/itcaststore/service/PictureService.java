package cn.itcast.itcaststore.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.itcaststore.dao.PictureDao;
import cn.itcast.itcaststore.domain.Picture;



public class PictureService {
	PictureDao dao = new PictureDao();

	//后台系统，查询所有公告
	public List<Picture> getAllPictures(){
		try {
			return dao.getAllPictures();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("根据id查找图片失败！");
		}
	}
	
	public List<Picture> showPictures(){
		try {
			return dao.showPictures();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("根据id显示图片失败！");
		}
	}
	
	
	
	//后台系统，添加图片
	public void addPicture(Picture p) {
		try {
			dao.addPicture(p);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加图片失败!");
		}
	}
	
	//后台系统，根据id查找图片
	public Picture findPictureById(String id) {
		try {
			return dao.findPictureById(id);
		} catch (SQLException e) {
			throw new RuntimeException("根据id查找图片失败！");
		}
	}
	
	//后台系统，根据id修改图片
	public void updatePicture(Picture p) {
		try {
			dao.updatePicture(p);
		} catch (SQLException e) {
//			throw new RuntimeException("根据id修改图片失败！");
			e.printStackTrace();
		}
	}
	
	//后台系统，根据id删除图片
	public void deletePicture(String id) {
		try {
			dao.deletePicture(id);
		} catch (SQLException e) {
			throw new RuntimeException("根据id删除图片失败！");
		}
	}
	

}
