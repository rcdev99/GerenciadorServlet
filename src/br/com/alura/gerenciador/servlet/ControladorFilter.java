package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acoes.IAcoes;

/**
 * Servlet Filter implementation class ControladorFilter
 */
//@WebFilter("/entrada")
public class ControladorFilter implements Filter {

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("Executando Controlador");
		
		//Casting para utilização das classes HttpServletRequest e HttpServletResponse
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		//Recebendo parâmetro que define a ação do controlador
		String acao = request.getParameter("acao");
		
		//Construindo nome da classe de acordo com a ação solicitada
		String nomeClasse = "br.com.alura.gerenciador.acoes." + acao;
		//variável para possibilitar o redirecionamento de acordo com o retorno da acao
		String nome;
		
		//Reflection para instancia do Action a ser executado
				try {
					Class classe  = Class.forName(nomeClasse);
					IAcoes action = (IAcoes) classe.newInstance();
					nome = action.executa(request, response);
				} catch (ClassNotFoundException | 
		                InstantiationException | 
		                IllegalAccessException e) {
		            throw new ServletException(e);
		        }
				
				String[] tipoEEndereco = nome.split(":");
		        if(tipoEEndereco[0].equals("forward")) {
		            RequestDispatcher rd = 
		                request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
		            rd.forward(request, response);
		        } else {
		            response.sendRedirect(tipoEEndereco[1]);
		        }        
	}

}
