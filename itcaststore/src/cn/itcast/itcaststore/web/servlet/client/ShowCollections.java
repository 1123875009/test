package cn.itcast.itcaststore.web.servlet.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.itcaststore.domain.User;
import cn.itcast.itcaststore.service.CollectionService;

/**
 * Servlet implementation class ShowCollections
 */
public class ShowCollections extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCollections() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CollectionService service = new CollectionService();
		 HttpSession session = request.getSession();
		String id = request.getParameter("id"); //得到商品编号
		User u=(User) session.getAttribute("user");
		List<Object[]> cList=service.getCollections(u.getId());
		session.setAttribute("cList", cList);
		response.sendRedirect(request.getContextPath() + "/client/collectProduct.jsp");
		
	}

}
