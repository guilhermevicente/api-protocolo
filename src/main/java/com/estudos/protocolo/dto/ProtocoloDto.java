package com.estudos.protocolo.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class ProtocoloDto extends BaseDto {

	@ApiModelProperty(value = "Tipo do protocolo")
	private String tipo;

	private List<DocumentoDto> documentos;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(final String tipo) {
		this.tipo = tipo;
	}

	public List<DocumentoDto> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(final List<DocumentoDto> documentos) {
		this.documentos = documentos;
	}
}
