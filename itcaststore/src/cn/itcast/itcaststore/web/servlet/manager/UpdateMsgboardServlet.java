package cn.itcast.itcaststore.web.servlet.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.itcaststore.domain.Msgboard;
import cn.itcast.itcaststore.domain.User;
import cn.itcast.itcaststore.service.MsgboardService;

/**
 * Servlet implementation class UpdateMsgboardServlet
 */
public class UpdateMsgboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Msgboard msgboard=new Msgboard();
		MsgboardService msgboardService=new MsgboardService();
		User user=new User();
		String msgcontent=request.getParameter("msgcontent");
		String username=request.getParameter("username");
		user.setUsername(username);
		msgboard.setMsgcontent(msgcontent);
		msgboard.setUser(user);
	    msgboardService.addMsgboard(msgboard);
		request.getRequestDispatcher("/client/helpcenter.jsp").forward(request, response);;
		
	}

}
