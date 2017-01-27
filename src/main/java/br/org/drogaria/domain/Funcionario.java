package br.org.drogaria.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Funcionario extends GenericDomain {
	@Column(nullable = false, length = 14, unique = true)
	private String carteiraTralho;
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataAdmicao;
	@OneToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;

	public String getCarteiraTralho() {
		return carteiraTralho;
	}

	public void setCarteiraTralho(String carteiraTralho) {
		this.carteiraTralho = carteiraTralho;
	}

	public Date getDataAdmicao() {
		return dataAdmicao;
	}

	public void setDataAdmicao(Date dataAdmicao) {
		this.dataAdmicao = dataAdmicao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
