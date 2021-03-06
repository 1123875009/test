package cn.itcast.itcaststore.web.servlet.manager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.itcaststore.service.ProductService;

public class DownloadServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		ProductService service = new ProductService();
		List<Object[]> ps = service.download(year,month);//返回的是一个列表，列表的每一项是一个数组
		String fileName=year+"年"+month+"月销售榜单.csv";	
		response.setContentType(this.getServletContext().getMimeType(fileName));
		response.setHeader("Content-Disposition", "attachement;filename="+new String(fileName.getBytes("GBK"),"iso8859-1"));		
		response.setCharacterEncoding("gbk");		
		PrintWriter out = response.getWriter();
		out.println("商品名称,销售数量");
		for (int i = 0; i < ps.size(); i++) {//遍历列表，取出来每一数组
			Object[] arr=ps.get(i);
			out.println(arr[0]+","+arr[1]);//因为数组只有 名称 和数量，所以打印数组的前两项
		}
		out.flush();
		out.close();
	}
}
