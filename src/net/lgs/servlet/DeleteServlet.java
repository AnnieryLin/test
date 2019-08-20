package net.lgs.servlet;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.lgs.service.IRecordServ;
import net.lgs.service.RecordServImpl;

/**
 * Servlet implementation class DeleteServlet
 * （根据打分记录id）在score_table和tmp_record中删除对应的记录
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("getRequestURL: "+request.getRequestURL());
		System.out.println("getRequestURI: "+request.getRequestURI());
		System.out.println("getQueryString: "+request.getQueryString());

		int scoreId = 0;
		Map<String, ?> map = request.getParameterMap();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
        	String[] values = (String[]) map.get(key);
			for (String value : values) {
				//System.out.println(key+" = "+value);
				scoreId = Integer.parseInt(value);
			}
        }
		// int scoreId = (int)request.getAttribute("id");
		IRecordServ recordserv = new RecordServImpl();
		if (recordserv.deleteRecord(scoreId)) {
			System.out.println(TimeZone.getDefault());
			request.getRequestDispatcher("/query").forward(request,response);
		} else {
			response.getWriter().write("<script type=\"text/javascript/\">window.alert(\"删除失败！\");</script>");
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
