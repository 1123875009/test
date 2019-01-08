package cn.itcast.itcaststore.web.servlet.manager;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.itcaststore.domain.Notice;
import cn.itcast.itcaststore.domain.Picture;
import cn.itcast.itcaststore.service.NoticeService;
import cn.itcast.itcaststore.service.PictureService;

/**
 * Servlet implementation class AddPictureServlet
 */
public class AddPictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPictureServlet() {
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
		Picture p = new Picture();
		String title = request.getParameter("title");
		//将当前时间设为添加公告的时间
		String t = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		p.setTitle(p.getTitle());
		//调用addNotice方法
		service.addPicture(p);
		//转发  相当于添加过后刷新页面，重新将公告查找一遍
		request.getRequestDispatcher("/manager/autoplayServlet").forward(request, response);
	
	}

}
