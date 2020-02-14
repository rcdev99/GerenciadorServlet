package br.com.alura.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Objeto;
import br.com.alura.gerenciador.model.SimulaBD;

public class ActionAlterarObjetos implements IAcoes {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				//Instanciando vari�veis locais para o processo de altera��o do objeto
				SimulaBD bd = new SimulaBD();
				
				//Obtendo dados da requisi��o
				String nomeObj = request.getParameter("nome");
				String paramId = request.getParameter("id");
				Integer id = Integer.valueOf(paramId);
				
				//Obtendo o objeto que ser� alterado
				Objeto obj = bd.obterObjetoPeloId(id);
				
				//Efetuando altera��es
				obj.setNome(nomeObj);
				
				//Redirecionando p�ginas
				return "redirect:entrada?acao=ActionListarObjetos";

	}

}
