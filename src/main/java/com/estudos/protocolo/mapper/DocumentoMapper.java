package com.estudos.protocolo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.estudos.protocolo.domain.Documento;
import com.estudos.protocolo.dto.DocumentoDto;

@Component
public class DocumentoMapper {

	public Documento mapear(final DocumentoDto dto) {
		final Documento documento = new Documento();
		documento.setAutor(dto.getAutor());
		documento.setDescricao(dto.getDescricao());
		documento.setNome(dto.getNome());
		documento.setUsuario(dto.getUsuario());
		return documento;
	}

	public List<Documento> mapear(final List<DocumentoDto> lsDto) {
		return lsDto.stream().map(this::mapear).collect(Collectors.toList());
	}
}
