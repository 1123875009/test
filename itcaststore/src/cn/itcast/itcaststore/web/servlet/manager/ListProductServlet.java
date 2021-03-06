package cn.itcast.itcaststore.web.servlet.manager;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.itcaststore.domain.PageBean;
import cn.itcast.itcaststore.domain.Product;
import cn.itcast.itcaststore.exception.ListProductException;
import cn.itcast.itcaststore.service.ProductService;
/**
 * 后台系统
 * 查询所有商品信息的servlet
 * 实现分页
 */
public class ListProductServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		        // 1.定义当前页码，默认为1
				int currentPage = 1;
				String _currentPage = request.getParameter("currentPage");
				if (_currentPage != null) {
					currentPage = Integer.parseInt(_currentPage);
				}
				// 2.定义每页显示条数,默认为8
				int currentCount = 8;
				String _currentCount = request.getParameter("currentCount");
				if (_currentCount != null) {
					currentCount = Integer.parseInt(_currentCount);
				}
				// 3.获取查找的分类
				String category = "全部商品";
				String _category = request.getParameter("category");
				if (_category != null) {
					category = _category;
				}
				
				// 4.调用service，完成获取当前页分页Bean数据.
				ProductService service = new ProductService();
				List<Product> ps;
			    PageBean bean = service.findProductByPage(currentPage, currentCount,category);
				// 将数据存储到request范围，跳转到product_list.jsp页面展示
				request.setAttribute("bean", bean);
				request.getRequestDispatcher("/admin/products/list.jsp").forward(
													request, response);
				return;
				
			}
}
