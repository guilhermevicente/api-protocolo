package com.estudos.protocolo.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estudos.protocolo.domain.Documento;
import com.estudos.protocolo.domain.Protocolo;
import com.estudos.protocolo.dto.ProtocoloDto;

@Component
public class ProtocoloMapper {

	@Autowired
	private DocumentoMapper documentoMapper;

	public Protocolo mapear(final ProtocoloDto dto) {
		final Protocolo protocolo = new Protocolo();
		protocolo.setAutor(dto.getAutor());
		final List<Documento> documentos = documentoMapper.mapear(dto.getDocumentos());
		for (final Documento documento : documentos) {
			protocolo.addDocumento(documento);
		}
		protocolo.setUsuario(dto.getUsuario());
		protocolo.setTipo(dto.getTipo());
		return protocolo;
	}
}
