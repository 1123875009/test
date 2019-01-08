package cn.itcast.itcaststore.web.servlet.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.itcaststore.dao.PictureDao;
import cn.itcast.itcaststore.domain.Picture;
import cn.itcast.itcaststore.service.PictureService;

/**
 * Servlet implementation class FindByIdPictureServlet
 */
public class FindByIdPictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindByIdPictureServlet() {
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
		String id = request.getParameter("id");
		PictureService service = new PictureService();
		Picture p = new Picture();
		p.setId(id);
		service.findPictureById(id);
		request.setAttribute("p",Picture);
		//转发
		request.getRequestDispatcher("/admin/autoplaymanage/edit.jsp").forward(request, response);
	}

}
