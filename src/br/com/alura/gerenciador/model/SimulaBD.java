package br.com.alura.gerenciador.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimulaBD {

	private static List<Objeto> objetos = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();
	
	static {
		//Instancia de objetos para popular os Array�s
		Objeto obj1 = new Objeto("Guarda Chuva");
		Objeto obj2 = new Objeto("Guarda Sol");
		Usuario user1 = new Usuario("admin","123");
		Usuario user2 = new Usuario("user","123");
		
		//Populando Array�s
		objetos.add(obj1);
		objetos.add(obj2);
		usuarios.add(user1);
		usuarios.add(user2);
	}
	/**
	 * M�todo para obter os objetos da lista
	 * @return objetos - ArrayList contendo lista de objetos 
	 */
	public static List<Objeto> getObjetos() {
		return objetos;
	}
	/**
	 * M�todo para adicionar objetos no array destinado a eles
	 * @param object
	 */
	public static void addObjetos(Objeto object) {
		objetos.add(object);
	}
	/**
	 * M�todo utilizado para remo��o de objetos da lista
	 * @param id
	 */
	public void rmObjetos(Integer id) {
		
		//Instanciando um iterador para poder manipular a lista dentro de um la�o.
		Iterator<Objeto> itObj = objetos.iterator();
		
		while(itObj.hasNext()) {
			//Instanciando objeto referente a itera��o atual
			Objeto obj = itObj.next();
			//Remove o objeto da itera��o, caso possua o mesmo ID.
			if(obj.getId() == id) {
				itObj.remove();
			}
			
		}
	}
	/**
	 * M�todo para obter um ojeto espec�fico atrav�s do seu ID
	 * @param id Identificador �nico para um objeto da lista
	 * @return null Caso n�o encontre nenhum id compat�vel com o par�metro informado
	 */
	public Objeto obterObjetoPeloId(Integer id) {
		for (Objeto objeto : objetos) {
			
			if (objeto.getId() == id) {
				
				return objeto;
			}
		}
		return null;
	}
	/**
	 * M�todo utilizado para se obter a lista de usu�rios.
	 * @return List contendo os usu�rios cadastrados
	 */
	public static List<Usuario> getUsuarios() {
		return usuarios;
	}
	/**
	 * M�todo utilizado para inserir um novo usu�rio � listagem
	 * @param usuario Representando um instancia da classe Usu�rio
	 */
	public static void addUsuario(Usuario usuario) {
		SimulaBD.usuarios.add(usuario);
	}
	/**
	 * M�todo que percorre a lista de usu�rios verificando se identifica credencias iguais ao par�metro recebido
	 * @param login String que representa a credencial de acesso ao sistema
	 * @param senha String contendo senha de acesso ao sistema
	 * @return usuario Instancia da classe Usu�rio caso login e senha existam, retorna null caso contr�rio.
	 */
	public Usuario existeUsuario(String login, String senha) {
	    for(Usuario usuario : usuarios) {
	        if(usuario.ehIgual(login, senha)) {
	            return usuario;
	        }
	    }
	    return null;
	}
	
	
}
