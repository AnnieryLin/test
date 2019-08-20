package net.lgs.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.lgs.domain.Record;
import net.lgs.domain.User;
import net.lgs.service.IRecordServ;
import net.lgs.service.RecordServImpl;

/**
 * Servlet implementation class QueryServlet
 * （根据用户id）查询当前用户已提交的评分记录
 */
@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryServlet() {
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
			int userId = ((User)request.getSession().getAttribute("user")).getId(); // 获取当前用户的用户id
			IRecordServ recordserv = new RecordServImpl();
			ArrayList<Record> records = recordserv.queryByUser(userId); // 查询结果返回到records中
			request.getSession().setAttribute("records", records); // 存入session属性值
			request.getRequestDispatcher("query2.jsp").forward(request, response); // 转发到query页面
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
