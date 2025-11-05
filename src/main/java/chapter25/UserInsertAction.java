package chapter25;

import dao.CustomerDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class UserInsertAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		if (login != null && !login.isEmpty() && password != null && !password.isEmpty()) {
			CustomerDAO dao = new CustomerDAO();
			int result = dao.insert(login, password);
			
			if (result > 0) {
				return "userInsert.jsp";
			}
		}
		
		return "userInsert.jsp";
	}
}
