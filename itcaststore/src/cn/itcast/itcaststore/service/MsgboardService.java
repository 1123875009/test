package cn.itcast.itcaststore.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.itcaststore.dao.MsgBoardDao;
import cn.itcast.itcaststore.domain.Msgboard;

public class MsgboardService {
MsgBoardDao msgBoardDao=new MsgBoardDao();

public List<Msgboard> getMsgboards(){
	try {
		return msgBoardDao.queryMsgboard();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw  new RuntimeException("获取留言板失败");
	}
}
public void addMsgboard(Msgboard msgboard){
	try {
		msgBoardDao.addMsgboard(msgboard);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void UpdateMsgboard(Msgboard msgboard) {
	try {
		msgBoardDao.UpdateMsgboard(msgboard);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public List<Msgboard> queryMsgboard(String name){
     try {
		return msgBoardDao.queryMsgboard(name);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}

	
}

