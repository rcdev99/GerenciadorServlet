package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acoes.IAcoes;

/**
 * Servlet implementation class ControladorCentralServlet
 */
@WebServlet("/entrada")
public class ControladorCentralServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "rawtypes", "deprecation" })
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recebendo parâmetro que define a ação do controlador
		String acao = request.getParameter("acao");
				
		//Validando Sessão HTTP
		HttpSession sessao = request.getSession();
		boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
		boolean ehUmaAcaoProtegida = !(acao.equals("ActionLogin") || acao.equals("ActionFormLogin"));
		
		//Construindo nome da classe de acordo com a ação solicitada
		String nomeClasse = "br.com.alura.gerenciador.acoes." + acao;
		//variável para possibilitar o redirecionamento de acordo com o retorno da acao
		String nome;
		
		//Redirecionando para a tela de login caso a sessão não esteja válida
		if(ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
		    response.sendRedirect("entrada?acao=ActionFormLogin");
		    return;
		}
		
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
