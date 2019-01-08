package cn.itcast.itcaststore.web.servlet.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.itcaststore.domain.Collection;
import cn.itcast.itcaststore.domain.Product;
import cn.itcast.itcaststore.domain.User;
import cn.itcast.itcaststore.exception.FindProductByIdException;
import cn.itcast.itcaststore.service.CollectionService;
import cn.itcast.itcaststore.service.ProductService;

/**
 * Servlet implementation class CollectionServlet
 */
public class AddCollectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCollectionServlet() {
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
		// 1.得到商品id
		       HttpSession session = request.getSession();
				String id = request.getParameter("id"); //得到商品编号
				CollectionService service = new CollectionService();
				Collection c = new Collection();
				User u=(User) session.getAttribute("user");
				c.setProduct_id(id);
				c.setUser_id(u.getId());
				//System.out.println(u.getId());
				service.addCollection(c);
				
				
				//List<Object[]> cList=service.getCollections(u.getId());
				//request.setAttribute("cList", cList);//将查询到了商品列表放入request对象中
				//session.setAttribute("cList", cList);
				//请求转发
				request.getRequestDispatcher("/ShowCollections").forward(request, response);
				//response.sendRedirect(request.getContextPath() + "/client/collectProduct.jsp");
	}

}
