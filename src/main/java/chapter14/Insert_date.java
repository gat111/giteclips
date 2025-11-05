package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.sql.Timestamp;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;


@WebServlet(urlPatterns={"/chapter14/insert_date"})
public class Insert_date extends HttpServlet {

	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup(
				"java:/comp/env/jdbc/book");
			Connection con=ds.getConnection();
			
			String EVENT_DATE=request.getParameter("EVENT_DATE");
			String EVENT_TIME=request.getParameter("EVENT_TIME");
			String EVENT_TIMESTAMP=request.getParameter("EVENT_TIMESTAMP");
			
			
			
			PreparedStatement st=con.prepareStatement("INSERT INTO schedule (event_date, event_time, event_timestamp) VALUES (?, ?, ?)");
			st.setDate(1, Date.valueOf(EVENT_DATE));
			st.setTime(2, Time.valueOf(EVENT_TIME));
			st.setTimestamp(3, Timestamp.valueOf(EVENT_TIMESTAMP));
			
			int line=st.executeUpdate();
			
			if (line>0) {
				out.println("追加に成功しました。");
			}
			
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
