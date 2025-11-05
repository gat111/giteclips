package chapter25;

import bean.Customer;
import dao.CustomerDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class UserDeleteAction extends Action {
	public String execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		if (id != null && !id.isEmpty()) {
			CustomerDAO dao = new CustomerDAO();
			dao.delete(Integer.parseInt(id));
		}

		CustomerDAO dao = new CustomerDAO();
		java.util.List<Customer> list;

		list = dao.getAll();

		session.setAttribute("list", list);
		return "userList.jsp";

	}
}
