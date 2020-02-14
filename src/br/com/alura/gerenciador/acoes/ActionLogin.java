package br.com.alura.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.model.SimulaBD;
import br.com.alura.gerenciador.model.Usuario;

public class ActionLogin implements IAcoes {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		SimulaBD bd = new SimulaBD();
		
		Usuario user = bd.existeUsuario(login, senha);
		
		if(user!=null) {
			System.out.println("Usuário encontrado !");
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", user);
			
			return "redirect:entrada?acao=ActionListarObjetos";

        } else {       	
            return "redirect:entrada?acao=ActionFormLogin";
        }

	}

}
