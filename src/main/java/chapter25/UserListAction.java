package chapter25;

import bean.Customer;
import dao.CustomerDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class UserListAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		CustomerDAO dao=new CustomerDAO();
		java.util.List<Customer> list;
		
		String keyword = request.getParameter("keyword");
		if (keyword != null && !keyword.isEmpty()) {
			list = dao.searchByKeyword(keyword);
		} else {
			list = dao.getAll();
		}
		
		request.setAttribute("list", list);
		return "userList.jsp";
	}
}
