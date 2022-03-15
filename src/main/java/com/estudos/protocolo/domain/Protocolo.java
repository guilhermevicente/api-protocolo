package com.estudos.protocolo.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Protocolo implements Serializable {

	private static final long serialVersionUID = -2785106984184860576L;

	@ApiModelProperty(value = "Identificador do protocolo")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

	@ApiModelProperty(value = "Chave do protocolo. Gerada automaticamente.")
	private String chave;

	@ApiModelProperty(value = "Tipo do protocolo")
	private String tipo;

	@ApiModelProperty(value = "Data/Hora da criação do protocolo")
	protected LocalDateTime dtHrCadastro;

	@JsonManagedReference
	@OneToMany(mappedBy = "protocolo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Documento> documentos;

	@ApiModelProperty(value = "Usuário que está cadastrando o protocolo")
	protected String usuario;

	@ApiModelProperty(value = "Autor que está solicitando a criação do protocolo")
	protected String autor;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(final String chave) {
		this.chave = chave;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(final List<Documento> documentos) {
		this.documentos = documentos;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(final String tipo) {
		this.tipo = tipo;
	}

	public LocalDateTime getDtHrCadastro() {
		return dtHrCadastro;
	}

	public void setDtHrCadastro(final LocalDateTime dtHrCadastro) {
		this.dtHrCadastro = dtHrCadastro;
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
		final Protocolo other = (Protocolo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void addDocumento(final Documento documento) {
		if (Objects.isNull(this.documentos))
			this.documentos = new ArrayList<>();
		this.documentos.add(documento);
		documento.setProtocolo(this);
	}

	public void removeDocumento(final Documento documento) {
		if (Objects.nonNull(this.documentos)) {
			documentos.remove(documento);
			documento.setProtocolo(null);
		}
	}
}
