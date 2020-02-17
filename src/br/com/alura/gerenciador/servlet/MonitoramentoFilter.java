package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class MonitoramentoFilter
 */
//@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("Filtro de monitoramento");
		
		//Definindo tempo de execu��o no momento da entrada do m�todo
		long anterior = System.currentTimeMillis();
		
		//Obtendo dados da requisi��o para identificar a a��o que foi invocada
		String acao = request.getParameter("acao");
		
		//Invoca��o da cadei de filtragem
		chain.doFilter(request, response);
		
		//Definindo tempo de execu��o ap�s a sa�da do m�todo
		long posterior = System.currentTimeMillis();
		
		//Exibindo tempo de execu��o do m�todo para monitoramento
		System.out.println("Tempo de execu��o da a��o " + acao + " : " + (posterior - anterior));
		
		
	}

}
