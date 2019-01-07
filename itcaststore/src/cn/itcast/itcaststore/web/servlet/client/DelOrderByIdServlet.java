package cn.itcast.itcaststore.web.servlet.client;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.itcaststore.service.OrderService;
/**
 * 删除订单
 * @author admin
 *
 */
public class DelOrderByIdServlet extends HttpServlet {
	private static final long serialVersionUID = -742965707205621644L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 订单id
		String id = request.getParameter("id");//获取订单的id
		// 已支付的订单带有type值为client的参数
		String type = request.getParameter("type");
		OrderService service = new OrderService();
		if (type != null && type.trim().length() > 0) {//获取type的值不为空且不为空串，超级用户已支付订单发出删除的请求
			service.delOrderById(id);
			if ("admin".equals(type)) {//如果删除订单的请求来自后台，为admin用户
				request.getRequestDispatcher("/findOrders").forward(request, response);
				return;
			}
		} else {//普通用户未支付的订单发出删除的请求
			// 调用service层方法删除相应订单
			service.delOrderByIdWithClient(id);
		}
		//response.sendRedirect(request.getContextPath() + "/client/delOrderSuccess.jsp");
		request.getRequestDispatcher("/findOrderByUser").forward(request, response);
		return;
	}
}
