package cn.itcast.itcaststore.web.servlet.manager;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.itcaststore.domain.PageBean;
import cn.itcast.itcaststore.domain.Product;
import cn.itcast.itcaststore.service.ProductService;
public class FindProductByManyConditionServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获取表单数据
		String id = request.getParameter("id"); // 商品id
		String name = request.getParameter("name"); // 商品名称
		String category = request.getParameter("category"); // 商品类别
		String minprice = request.getParameter("minprice"); // 最小价格
		String maxprice = request.getParameter("maxprice"); // 最大价格
		// 2.创建ProductService对象
		ProductService service = new ProductService();
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
		category = "全部商品";
		String _category = request.getParameter("category");
		if (_category != null) {
			category = _category;
		}
		
		
		// 3.调用service层用于条件查询的方法
		PageBean bean = service.findProductByManyCondition(id, name,
				category, minprice, maxprice,currentCount,currentPage);
		// 4.将条件查询的结果放进request域中
		request.setAttribute("bean", bean);
		// 5.请求转发到商品管理首页list.jsp页面
		request.getRequestDispatcher("/admin/products/list.jsp").forward(
				request, response);
	}
}
