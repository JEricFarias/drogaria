package br.org.drogaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

// classe bean
@SuppressWarnings("serial")
@Entity
public class UnidadeFederativa extends GenericDomain {
	@Column(length = 2, nullable = false)
	private String sigla;
	@Column(length = 50, nullable = false)
	private String nome;

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
