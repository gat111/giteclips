package dao;

import bean.Item;
import bean.Product;
import bean.Purchase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class PurchaseDAO extends DAO {
	public boolean insert(List<Item> cart, String name, String address) throws Exception {
		Connection con=getConnection();
		con.setAutoCommit(false);

		for (Item item : cart) {
			PreparedStatement st=con.prepareStatement(
				"insert into purchase(product_id, product_name, "+
				"product_price, product_count, customer_name, "+
				"customer_address) values(?, ?, ?, ?, ?, ?)");
			Product p=item.getProduct();
			st.setInt(1, p.getId());
			st.setString(2, p.getName());
			st.setInt(3, p.getPrice());
			st.setInt(4, item.getCount());
			st.setString(5, name);
			st.setString(6, address);
			int line=st.executeUpdate();
			st.close();

			if (line!=1) {
				con.rollback();
				con.setAutoCommit(true);
				con.close();
				return false;
			}
		}

		con.commit();
		con.setAutoCommit(true);
		con.close();
		return true;
	}

	public List<Purchase> search(Integer minPrice, Integer maxPrice, String productName) throws Exception {
		List<Purchase> list = new ArrayList<>();

		Connection con = getConnection();

		StringBuilder sql = new StringBuilder("select * from purchase where 1=1");
		List<Object> params = new ArrayList<>();

		if (minPrice != null) {
			sql.append(" and product_price >= ?");
			params.add(minPrice);
		}
		if (maxPrice != null) {
			sql.append(" and product_price <= ?");
			params.add(maxPrice);
		}
		if (productName != null && !productName.isEmpty()) {
			sql.append(" and product_name like ?");
			params.add("%" + productName + "%");
		}

		sql.append(" order by id desc");

		PreparedStatement st = con.prepareStatement(sql.toString());
		for (int i = 0; i < params.size(); i++) {
			st.setObject(i + 1, params.get(i));
		}

		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			Purchase purchase = new Purchase();
			purchase.setId(rs.getInt("id"));
			purchase.setProductId(rs.getInt("product_id"));
			purchase.setProductName(rs.getString("product_name"));
			purchase.setProductPrice(rs.getInt("product_price"));
			purchase.setProductCount(rs.getInt("product_count"));
			purchase.setCustomerName(rs.getString("customer_name"));
			purchase.setCustomerAddress(rs.getString("customer_address"));
			list.add(purchase);
		}

		rs.close();
		st.close();
		con.close();

		return list;
	}
}
