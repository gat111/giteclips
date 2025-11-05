package chapter18;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/chapter18/add"})
public class Add extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {


		  String name = URLEncoder.encode("清水", StandardCharsets.UTF_8.toString());
	        String value = URLEncoder.encode("一樹", StandardCharsets.UTF_8.toString());


		Cookie cookie=new Cookie(name, value);
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
	}
}
