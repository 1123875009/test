package cn.itcast.itcaststore.web.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.itcaststore.domain.Notice;
import cn.itcast.itcaststore.domain.Picture;
import cn.itcast.itcaststore.service.NoticeService;
import cn.itcast.itcaststore.service.PictureService;

/**
 * Servlet implementation class AutoplayServlet
 */
public class AutoplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoplayServlet() {
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
		PictureService service = new PictureService();
		List<Picture> pictures = service.getAllPictures();
		//request.setAttribute("pictures", pictures);
		request.setAttribute("pictures", pictures);
		System.out.println(pictures);
		request.getRequestDispatcher("/admin/autoplaymanage/view.jsp").forward(request, response);
		//response.sendRedirect(request.getContextPath() + "/admin/autoplaymanage/view.jsp");
		
	}

}
