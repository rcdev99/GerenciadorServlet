package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.model.Objeto;
import br.com.alura.gerenciador.model.SimulaBD;

/**
 * Servlet implementation class ObjetosService
 */
@WebServlet("/objetos")
public class ObjetosService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		new SimulaBD();
		List<Objeto> objetos = SimulaBD.getObjetos();
		String valor = request.getHeader("Accept");
		
		System.out.println(valor);
		
		 if(valor.contains("xml")) {
	            XStream xstream = new XStream();
	            xstream.alias("objeto", Objeto.class);
	            String xml = xstream.toXML(objetos);  

	            response.setContentType("application/xml");
	            response.getWriter().print(xml);        
	        } else if(valor.endsWith("json")) {
	            Gson gson = new Gson();
	            String json = gson.toJson(objetos);  

	            response.setContentType("application/json");
	            response.getWriter().print(json);
	        } else {
	            response.setContentType("application/json");
	            response.getWriter().print("{'message':'no content'}");
	        }
	}


}
