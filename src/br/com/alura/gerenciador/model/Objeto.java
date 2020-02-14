package br.com.alura.gerenciador.model;

import java.util.Date;

public class Objeto {

	private int id;
	private String nome;
	private Date dtCadastro;
	private static int seqId = 7000;
	

	//Construtor
	public Objeto(String nmObjeto) {
		Objeto.seqId++;
		this.nome = nmObjeto;
		this.dtCadastro = new Date();
		this.id = seqId;
	}
	
	//Getters e Setters
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public static int getSeqId() {
		return seqId;
	}
	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	
	
	
}
