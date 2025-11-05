package chapter22;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import bean.STUDENTS;
import dao.STUDENTSDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns={"/chapter22/search_st"})
public class Search_st extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {

			STUDENTSDAO dao=new STUDENTSDAO();
			List<STUDENTS> list=dao.search("");

			request.setAttribute("STUDENTS", list);
			
			request.getRequestDispatcher("jstl_st.jsp")
				.forward(request, response);
			
			

		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
