package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
//@WebFilter("/entrada")
public class AutorizacaoFilter implements Filter {

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("Executando filtro de autorização");
		
		//Casting para utilizar os recursos das classes HttpServletRequest e HttpServletResponse
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		//Recebendo parâmetro que define a ação do controlador
		String acao = request.getParameter("acao");
					
		//Validando Sessão HTTP
		HttpSession sessao = request.getSession();
		boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
		boolean ehUmaAcaoProtegida = !(acao.equals("ActionLogin") || acao.equals("ActionFormLogin"));
		
		//Redirecionando para a tela de login caso a sessão não esteja válida
		if(ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
			response.sendRedirect("entrada?acao=ActionFormLogin");
			return;
		}
		
		//Redirecionando à cadeia de filtragem
		chain.doFilter(request, response);
	}

}
