package br.com.alura.gerenciador.acoes;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Objeto;
import br.com.alura.gerenciador.model.SimulaBD;

public class ActionListarObjetos implements IAcoes {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Obtendo lista est�tica do simulados de Banco de Dados
		List<Objeto> objetos = SimulaBD.getObjetos(); 
		
		//Incluindo lista de objetos na requisi��o
		request.setAttribute("objetos", objetos);
		
		//Retornando forward para redirecionar a a��o � outra p�gina
		return "forward:listarObjetos.jsp";
		
	}

}
