package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/servlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		 PrintWriter out = resp.getWriter();
	        out.println("<html>");
	        out.println("<body>");
	        out.println("<h1> Jóia ! </h1>");
	        out.println("<p> Deu certo a criação da Servlet </p>");
	        out.println("</body>");
	        out.println("</html>");
	}

}
