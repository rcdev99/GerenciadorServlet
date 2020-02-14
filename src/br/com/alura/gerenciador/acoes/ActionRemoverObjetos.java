package br.com.alura.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.SimulaBD;

public class ActionRemoverObjetos implements IAcoes {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obtendo parâmetros da requisição	
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);		
		//Instancia do Simulador de BD para a operação de exclusão
		SimulaBD bd = new SimulaBD();
		bd.rmObjetos(id);
		//Redirecionando páginas
		return "redirect:entrada?acao=ActionListarObjetos";

	}

}
