
package chapter23;

import java.util.List;

import bean.STUDENTS;
import dao.STUDENTSDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class Search_stAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		STUDENTSDAO dao=new STUDENTSDAO();
		List<STUDENTS> list=dao.search("");

		request.setAttribute("STUDENTS", list);

		return "list_st.jsp";
	}
}
