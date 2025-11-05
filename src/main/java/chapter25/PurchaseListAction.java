package chapter25;

import bean.Purchase;
import dao.PurchaseDAO;
import tool.Action;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

public class PurchaseListAction extends Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String minPriceParam = request.getParameter("minPrice");
		String maxPriceParam = request.getParameter("maxPrice");
		String productName = request.getParameter("productName");

		Integer minPrice = parseInteger(minPriceParam);
		Integer maxPrice = parseInteger(maxPriceParam);

		if (productName != null && productName.isBlank()) {
			productName = null;
		}

		if (minPrice != null && maxPrice != null && minPrice > maxPrice) {
			int tmp = minPrice;
			minPrice = maxPrice;
			maxPrice = tmp;
		}

		PurchaseDAO dao = new PurchaseDAO();
		List<Purchase> list = dao.search(minPrice, maxPrice, productName);

		request.setAttribute("list", list);
		request.setAttribute("minPrice", minPriceParam);
		request.setAttribute("maxPrice", maxPriceParam);
		request.setAttribute("productName", request.getParameter("productName"));

		return "purchaseList.jsp";
	}

	private Integer parseInteger(String value) {
		if (value == null || value.isBlank()) {
			return null;
		}
		try {
			return Integer.valueOf(value.trim());
		} catch (NumberFormatException e) {
			return null;
		}
	}
}
