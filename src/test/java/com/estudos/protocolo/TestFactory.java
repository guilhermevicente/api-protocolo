package com.estudos.protocolo;

import java.util.ArrayList;
import java.util.List;

import com.estudos.protocolo.dto.DocumentoDto;
import com.estudos.protocolo.dto.ProtocoloDto;

public class TestFactory {

	public static ProtocoloDto getProtocolo() {
		final ProtocoloDto protocolo = new ProtocoloDto();
		protocolo.setAutor("mock-autor");
		protocolo.setTipo("mock-tipo");
		protocolo.setUsuario("mock-usuario");
		protocolo.setDocumentos(getDocumentos());
		return protocolo;
	}

	private static List<DocumentoDto> getDocumentos() {
		final List<DocumentoDto> lsDocumento = new ArrayList<>();
		lsDocumento.add(getDocumento());
		return lsDocumento;
	}

	private static DocumentoDto getDocumento() {
		final DocumentoDto documentoDto = new DocumentoDto();
		documentoDto.setAutor("doc-mock-autor");
		documentoDto.setDescricao("doc-mock-descricao");
		documentoDto.setNome("doc-mock-nome");
		documentoDto.setUsuario("doc-mock-usuario");
		return documentoDto;
	}
}
