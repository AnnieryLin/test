package net.lgs.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.lgs.domain.Device;
import net.lgs.domain.User;
import net.lgs.service.DevServImpl;
import net.lgs.service.IDevServ;

/**
 * Servlet implementation class InsertServlet
 * 显示录入检测结果页面
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message = null;
		if(request.getSession(false) == null) {
			System.out.println("会话已失效，重新登录");
			message = String.format("会话已失效，请重新登录！%n3秒后将自动跳转到登录页面……<meta http-equiv='refresh' content='3;url=login.html'/>");
			request.getSession().setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request,response);
		} else {
			// 获取当前用户的用户id
			int userId = ((User)request.getSession().getAttribute("user")).getId();
			// 获取当前用户还未录入结果的设备，并传给request属性参数
			IDevServ devserv = new DevServImpl();
			ArrayList<Device> devs = devserv.getDevByUser(userId);
			request.getSession().setAttribute("devs", devs);
			request.getRequestDispatcher("insert2.jsp").forward(request, response);
		}

		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
