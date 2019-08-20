package net.lgs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.lgs.domain.User;
import net.lgs.service.IUserServ;
import net.lgs.service.UserServImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("username"); // 获取用户填写的登录用户名
		String password = request.getParameter("password"); // 获取用户填写的登录密码
		IUserServ service = new UserServImpl();
		// String pwdHash = BCrypt.hashpw(password, BCrypt.gensalt(12));
		User user = service.login(username, password); //用户登录
		String message;
		if(user == null) {
			message = String.format(
					"密码错误，请重新登录！%n3秒后将自动跳到登录页面……<meta http-equiv='refresh' content='3;url=login.html'/>");
		} else if(user.getId() == 0) {
			message = String.format(
					"用户名不存在，请重新登录或注册新用户！%n3秒后将自动跳到登录页面……<meta http-equiv='refresh' content='3;url=login.html'/>");
		} else {
			request.getSession().setAttribute("user", user); // 登录成功后，就将用户存储到session中
			message = String.format( // content值的'如果写在数字后面会有奇怪的错误哦（自动以null再次登录）
					"用户  %s 登录成功！%n将在3秒后跳到首页……<meta http-equiv='refresh' content='3;url=entry2.jsp'/>", username);
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		return;
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
