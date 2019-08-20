package net.lgs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.lgs.dao.IItemDao;
import net.lgs.dao.ItemDaoImpl;
import net.lgs.domain.Score;
import net.lgs.domain.User;
import net.lgs.exception.ScoreExistException;
import net.lgs.service.IScoreServ;
import net.lgs.service.ScoreServImpl;

/**
 * Servlet implementation class FillInServlet
 * 对用户填写的检测结果进行处理
 */
@WebServlet("/fill")
public class FillInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
			System.out.println("会话仍处于活跃状态");
			// 1. 获取总分计算规则表
			int[] item = null;
			IItemDao itemdao = new ItemDaoImpl();
			item = itemdao.getProportion();
			
			// 2.读取用户填入的检测结果（15个是1/否0），边读边计算总分
			int sum = 0; // 根据标准计算得到的总分
			String score_code = ""; // 评分结果字符串序列
			for (int i = 1; i <= 15; i++) {
				String tmp = request.getParameter("q" + i); // 获取第i题的填写结果
				score_code += tmp;
				sum += Integer.parseInt(tmp) * item[i]; // 计算总分
			}
			System.out.println("评分序列：" + score_code);
			
			try {
				// 3.把评分序列与总分一起存入数据库
				Score score = new Score();
				score.setCode(score_code);
				score.setTotal(sum);
				// 获取当前用户的用户id
				int userId = ((User)request.getSession().getAttribute("user")).getId();
				score.setUserId(userId);
				// 获取评分的设备id
				int devId = Integer.parseInt(request.getParameter("devId"));
				score.setDevId(devId);
				// 向score_table中插入一条记录，并满足外键约束
				IScoreServ scoreserv = new ScoreServImpl();
				scoreserv.addScore(score);
				
				// 4. 跳转到历史记录列表页面
				request.getRequestDispatcher("/query").forward(request,response);
			}  catch (ScoreExistException e) {
				message = String.format("您已对此设备录入过检测结果！");
				request.getSession().setAttribute("message", message);
				request.getRequestDispatcher("message.jsp").forward(request,response);
			}
		}

		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
