package cn.itcast.itcaststore.web.servlet.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.itcaststore.dao.MsgBoardDao;
import cn.itcast.itcaststore.domain.Msgboard;
import cn.itcast.itcaststore.domain.User;
import cn.itcast.itcaststore.service.MsgboardService;

/**
 * Servlet implementation class EnterMsgboard
 */
public class EnterMsgboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MsgboardService service = new MsgboardService();
		User u = (User) request.getSession().getAttribute("user");
		String name = u.getUsername();
		List<Msgboard> msgboards = service.queryMsgboard(name);
		request.setAttribute("ms", msgboards);
		request.getRequestDispatcher("/client/helpcenter.jsp").forward(request, response);
		//response.sendRedirect(request.getContextPath()+"/client/helpcenter.jsp");
	}

}
