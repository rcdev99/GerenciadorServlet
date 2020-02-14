package br.com.alura.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Objeto;
import br.com.alura.gerenciador.model.SimulaBD;

public class ActionExibirObjeto implements IAcoes {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Declaração de variáveis locais
				SimulaBD bd = new SimulaBD();
				
				//Obtendo parametros da requisição
				String paramId = request.getParameter("id");
				Integer id = Integer.valueOf(paramId);
				
				//Obtendo o objeto a ser alterado
				Objeto obj = bd.obterObjetoPeloId(id);
				
				//Inserindo o objeto a ser enviado na requisição
				request.setAttribute("objeto", obj);
				
				//Retornando forward para redirecionar a ação à outra página
				return "forward:formAlterarAlgo.jsp";
		
	}

}
