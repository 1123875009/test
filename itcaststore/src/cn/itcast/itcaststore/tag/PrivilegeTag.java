package cn.itcast.itcaststore.tag;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import cn.itcast.itcaststore.domain.User;

public class PrivilegeTag extends SimpleTagSupport {    //自定义标签 判断是否已经登录，若没有登录 则转向错误页面
	@Override
	public void doTag() throws JspException, IOException {
		PageContext context = (PageContext) this.getJspContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		HttpServletResponse response = (HttpServletResponse) context.getResponse();
		
		User user = (User) context.getSession().getAttribute("user");
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/client/error/privilege.jsp");
		}
	}
}
