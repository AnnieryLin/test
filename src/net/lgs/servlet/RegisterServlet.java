package net.lgs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.lgs.domain.User;
import net.lgs.exception.UserExistException;
import net.lgs.service.IUserServ;
import net.lgs.service.UserServImpl;
import net.lgs.util.BCrypt;

/**
 *  接收register页面提交到服务端的表单数据
 *  校验表单数据的合法性，如果校验失败跳回到register.jsp，并回显错误信息
 *  如果校验通过，调用service层向数据库中注册用户
 */
@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 接收register.jsp中的表单输入项的值
		String userName = request.getParameter("username"); // 得到jsp页面传过来的参数
		String userPwd = request.getParameter("password");
		String confirmPwd = request.getParameter("confirmPwd");

		/* 2. 校验表单输入项的值的合法性
		 *       如果校验失败，说明用户填写的表单数据不符合规则，则跳转回register.jsp
		 */
        if (!userName.matches("[0-9a-zA-Z]{3,15}")) {
        	String message = String.format(
					"提示：用户名必须是3-15位的字母、数字，请重新填写。%n"
					+ "3秒后将自动返回注册页面……<meta http-equiv='refresh' content='3;url=register.html'/>");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
        	return;
        }

        if (!userPwd.matches("[0-9a-zA-Z]{6,20}")) { // \\d{6,20}
        	String message = String.format(
					"提示：密码必须是6-20位的字母、数字，请重新填写。%n"
					+ "3秒后将自动返回注册页面……<meta http-equiv='refresh' content='3;url=register.html'/>");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
        	return;
        }

        // private String confirmPwd; 两次密码要一致
        if (confirmPwd != null && !confirmPwd.equals(userPwd)) {
        	String message = String.format(
					"提示：两次输入的密码不一致，请重新填写。%n"
					+ "3秒后将自动返回注册页面……<meta http-equiv='refresh' content='3;url=register.html'/>");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
        	return;
        }

        System.out.println("表单验证通过，开始注册……");
        // 3. 校验通过，继续注册
		try {
			User user = new User();
			user.setName(userName);
			// 先将密码加密
			String pwdHash = BCrypt.hashpw(userPwd, BCrypt.gensalt(12));
			user.setPassword(pwdHash);
			IUserServ service = new UserServImpl();
			service.register(user); // 调用service层提供的注册用户服务实现用户注册
			
			String message = String.format("注册成功！%n3秒后将自动跳转到登录页面……<meta http-equiv='refresh' content='3;url=login.html'/>");
			request.setAttribute("message", message); // 向request域中放置信息 (key, value)
			request.getRequestDispatcher("/message.jsp").forward(request,response);
		} catch (UserExistException e) {
			request.getRequestDispatcher("register.html").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "注册失败！");
			response.sendRedirect("login.html"); //重定向到首页
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
