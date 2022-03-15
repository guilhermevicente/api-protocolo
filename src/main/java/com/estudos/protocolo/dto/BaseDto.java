package com.estudos.protocolo.dto;

import io.swagger.annotations.ApiModelProperty;

public class BaseDto {

	@ApiModelProperty(value = "Usuário realizador da operação")
	private String usuario;

	@ApiModelProperty(value = "Autor do objeto")
	private String autor;

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
}
