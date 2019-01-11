package cn.itcast.itcaststore.web.servlet.client;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.itcaststore.domain.Order;
import cn.itcast.itcaststore.domain.User;
import cn.itcast.itcaststore.service.OrderService;
import cn.itcast.itcaststore.service.UserService;

public class ChangeOrderStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获得订单号数据
		String orderid = request.getParameter("orderid");
		String paySuccess = "恭喜您支付成功！";
		int sum=0;
		if (null != orderid) {
				OrderService service = new OrderService();
				// 根据订单号修改订单状态
				try {
					service.updateState(orderid);//将订单的状态置为已付款
					User user = (User) request.getSession().getAttribute("user");
					List<Order> orders = service.findOrderByUser(user);
					System.out.println(orders);
					for(Order o:orders){
						if(user.getState()==1){
							sum=(int) (sum+o.getMoney());
							
						}
					}
				//	System.out.println("--------------------------------"+sum);
					user.setScore(sum);
					System.out.println(user);
					UserService uservice = new UserService();
					uservice.changeScore(user);
					request.setAttribute("paySuccess", paySuccess);
				    HttpSession session = request.getSession();
				    session.removeAttribute("cart");
					request.getRequestDispatcher("/findOrderByUser").forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
					response.getWriter().write("修改订单状态失败");
				}
			}
	}
}
