package com.estudos.protocolo.dto;

import io.swagger.annotations.ApiModelProperty;

public class DocumentoDto extends BaseDto {

	@ApiModelProperty(value = "Nome do documento")
	private String nome;

	@ApiModelProperty(value = "Descrição do documento")
	private String descricao;

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
}
