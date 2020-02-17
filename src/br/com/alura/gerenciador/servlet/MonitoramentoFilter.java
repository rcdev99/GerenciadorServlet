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
		
		//Definindo tempo de execução no momento da entrada do método
		long anterior = System.currentTimeMillis();
		
		//Obtendo dados da requisição para identificar a ação que foi invocada
		String acao = request.getParameter("acao");
		
		//Invocação da cadei de filtragem
		chain.doFilter(request, response);
		
		//Definindo tempo de execução após a saída do método
		long posterior = System.currentTimeMillis();
		
		//Exibindo tempo de execução do método para monitoramento
		System.out.println("Tempo de execução da ação " + acao + " : " + (posterior - anterior));
		
		
	}

}
