package br.com.unesc;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class IndexBean {
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}