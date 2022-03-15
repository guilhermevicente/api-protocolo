package com.estudos.protocolo.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Documento implements Serializable {

	private static final long serialVersionUID = -3901570255202880798L;

	@ApiModelProperty(value = "Identificador do documento")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

	@ApiModelProperty(value = "Nome do documento")
	private String nome;

	@ApiModelProperty(value = "Descrição do documento")
	private String descricao;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "protocolo_id")
	private Protocolo protocolo;

	@ApiModelProperty(value = "Usuário que está cadastrando o documento")
	protected String usuario;

	@ApiModelProperty(value = "Autor do documento")
	protected String autor;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

	public Protocolo getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(final Protocolo protocolo) {
		this.protocolo = protocolo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(final String usuario) {
		this.usuario = usuario;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(final String autor) {
		this.autor = autor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Documento other = (Documento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
