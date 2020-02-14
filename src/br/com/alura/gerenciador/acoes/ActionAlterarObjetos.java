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
		
				//Instanciando variáveis locais para o processo de alteração do objeto
				SimulaBD bd = new SimulaBD();
				
				//Obtendo dados da requisição
				String nomeObj = request.getParameter("nome");
				String paramId = request.getParameter("id");
				Integer id = Integer.valueOf(paramId);
				
				//Obtendo o objeto que será alterado
				Objeto obj = bd.obterObjetoPeloId(id);
				
				//Efetuando alterações
				obj.setNome(nomeObj);
				
				//Redirecionando páginas
				return "redirect:entrada?acao=ActionListarObjetos";

	}

}
