package br.com.alura.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.SimulaBD;

public class ActionRemoverObjetos implements IAcoes {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obtendo par�metros da requisi��o	
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);		
		//Instancia do Simulador de BD para a opera��o de exclus�o
		SimulaBD bd = new SimulaBD();
		bd.rmObjetos(id);
		//Redirecionando p�ginas
		return "redirect:entrada?acao=ActionListarObjetos";

	}

}
