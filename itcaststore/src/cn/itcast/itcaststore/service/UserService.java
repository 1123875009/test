package cn.itcast.itcaststore.service;
import java.sql.SQLException;
import java.util.Date;
import javax.security.auth.login.LoginException;

import cn.itcast.itcaststore.dao.UserDao;
import cn.itcast.itcaststore.domain.User;
import cn.itcast.itcaststore.exception.ActiveUserException;
import cn.itcast.itcaststore.exception.RegisterException;
import cn.itcast.itcaststore.utils.MD5Util;
import cn.itcast.itcaststore.utils.MailUtils;


public class UserService {
	private UserDao dao = new UserDao();
	// 注册操作
	public void register(User user) throws RegisterException {
		// 调用dao完成注册操作
		try {
			String pwd=MD5Util.MD5(user.getPassword());
			user.setPassword(pwd);
			dao.addUser(user);//将用户插入表中
			// 发送激活邮件
			String emailMsg = "感谢您注册网上书城，点击"
					+ "<a href='http://localhost:8080/bookstore/activeUser?activeCode="
					+ user.getActiveCode() + "'>&nbsp;激活&nbsp;</a>后使用。"
							+ "<br />为保障您的账户安全，请在24小时内完成激活操作";
			MailUtils.sendMail(user.getEmail(), emailMsg);//发送邮件 激活码
		} catch (Exception e) {
			e.printStackTrace();
			throw new RegisterException("注冊失败");
		}
	}
	// 激活用户
	public void activeUser(String activeCode) throws ActiveUserException {
		try {
			// 根据激活码查找用户
			User user = dao.findUserByActiveCode(activeCode);
			if (user == null) {
				throw new ActiveUserException("激活用户失败");
			}
			// 判断激活码是否过期 24小时内激活有效.
			// 1.得到注册时间
			Date registTime = user.getRegistTime();
			// 2.判断是否超时
			long time = System.currentTimeMillis() - registTime.getTime();
			if (time / 1000 / 60 / 60 > 24) {
				throw new ActiveUserException("激活码过期");
			}
			// 激活用户，就是修改用户的state状态
			dao.activeUser(activeCode);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ActiveUserException("激活用户失败");
		}
	}
	// 登录操作
	public User login(String username, String password) throws LoginException {
		try {
			String pwd = MD5Util.JM(MD5Util.KL(MD5Util.MD5(password)));
			//根据登录时表单输入的用户名和密码，查找用户
			User user = dao.findUserByUsernameAndPassword(username, pwd);
			//如果找到，还需要确定用户是否为激活用户
			if (user != null) {
				// 只有是激活才能登录成功，否则提示“用户未激活”
				if (user.getState() == 1) {
					return user;
				}
				throw new LoginException("用户未激活");
			}
			throw new LoginException("用户名或密码错误");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LoginException("登录失败");
		}
	}
	public void changeScore(User u){
		try {
			dao.changeScore(u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	public User findUserByUsernameAndPassword(String name, String password){
		try {
			//String p = MD5Util.MD5(password);
			String p=MD5Util.MD5(password);
			System.out.println("加密后密码："+p);
			User u = dao.findUserByUsernameAndPassword(name,p);
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}//sql，返回的user对象，两个占位符的参数
	
	public void changePassword(User u){
		try {
			String pwd = u.getPassword();
			String p = MD5Util.MD5(pwd);
			System.out.println("修改后的密码加密为"+p);
			u.setPassword(p);
			dao.changePassword(u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
