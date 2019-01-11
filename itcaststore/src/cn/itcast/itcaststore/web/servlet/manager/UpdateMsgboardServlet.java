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
		String id=request.getParameter("reply");
		int msg_id=Integer.parseInt(id);
		String string=request.getParameter("replycontent");
		Msgboard msgboard=new Msgboard();
		msgboard.setMsg_id(msg_id);
		msgboard.setMsgreply(string);
		MsgboardService msgboardService=new MsgboardService();
		msgboardService.UpdateMsgboard(msgboard);
		request.getRequestDispatcher("/manager/ListMsgboard").forward(request, response);
	}

}
