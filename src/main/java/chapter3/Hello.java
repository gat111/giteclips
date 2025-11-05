package chapter3;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/chapter3/hello"})
public class Hello extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/plain; charset=UTF-8");
		out.println("こんにちわ!");
		out.println("Hellssss33333ssssssss!");
		out.println("Hellssss33333ssssssss!");
		out.println("Hellssss33333ssssssss!");
		out.println(new java.util.Date());
	
	}

}
