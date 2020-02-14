package br.com.alura.gerenciador.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimulaBD {

	private static List<Objeto> objetos = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();
	
	static {
		//Instancia de objetos para popular os Array´s
		Objeto obj1 = new Objeto("Guarda Chuva");
		Objeto obj2 = new Objeto("Guarda Sol");
		Usuario user1 = new Usuario("admin","123");
		Usuario user2 = new Usuario("user","123");
		
		//Populando Array´s
		objetos.add(obj1);
		objetos.add(obj2);
		usuarios.add(user1);
		usuarios.add(user2);
	}
	/**
	 * Método para obter os objetos da lista
	 * @return objetos - ArrayList contendo lista de objetos 
	 */
	public static List<Objeto> getObjetos() {
		return objetos;
	}
	/**
	 * Método para adicionar objetos no array destinado a eles
	 * @param object
	 */
	public static void addObjetos(Objeto object) {
		objetos.add(object);
	}
	/**
	 * Método utilizado para remoção de objetos da lista
	 * @param id
	 */
	public void rmObjetos(Integer id) {
		
		//Instanciando um iterador para poder manipular a lista dentro de um laço.
		Iterator<Objeto> itObj = objetos.iterator();
		
		while(itObj.hasNext()) {
			//Instanciando objeto referente a iteração atual
			Objeto obj = itObj.next();
			//Remove o objeto da iteração, caso possua o mesmo ID.
			if(obj.getId() == id) {
				itObj.remove();
			}
			
		}
	}
	/**
	 * Método para obter um ojeto específico através do seu ID
	 * @param id Identificador único para um objeto da lista
	 * @return null Caso não encontre nenhum id compatível com o parâmetro informado
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
	 * Método utilizado para se obter a lista de usuários.
	 * @return List contendo os usuários cadastrados
	 */
	public static List<Usuario> getUsuarios() {
		return usuarios;
	}
	/**
	 * Método utilizado para inserir um novo usuário à listagem
	 * @param usuario Representando um instancia da classe Usuário
	 */
	public static void addUsuario(Usuario usuario) {
		SimulaBD.usuarios.add(usuario);
	}
	/**
	 * Método que percorre a lista de usuários verificando se identifica credencias iguais ao parâmetro recebido
	 * @param login String que representa a credencial de acesso ao sistema
	 * @param senha String contendo senha de acesso ao sistema
	 * @return usuario Instancia da classe Usuário caso login e senha existam, retorna null caso contrário.
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
