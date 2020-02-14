package br.com.alura.gerenciador.acoes;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Objeto;
import br.com.alura.gerenciador.model.SimulaBD;

public class ActionCadastrarObjetos implements IAcoes {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Instanciando simulador de Banco de Dados
				@SuppressWarnings("unused")
				SimulaBD bd = new SimulaBD();
				
				//Obtendo parâmetros
				String objetoCadastrado = request.getParameter("objeto");
				
				//Tratamento da data cadastrada
				Date dtAbertura = new Date();
				
				//Instanciando objetos com o parâmetro obtido
				Objeto obj = new Objeto(objetoCadastrado);
				obj.setDtCadastro(dtAbertura);
				
				//Adicionando o objeto criado ao banco
				SimulaBD.addObjetos(obj);
				
				//Inserindo o objeto a ser enviado na requisição
				request.setAttribute("objeto", obj.getNome());
				
				//Redirecionamento
				return "redirect:entrada?acao=ActionListarObjetos";
		
	}

}
