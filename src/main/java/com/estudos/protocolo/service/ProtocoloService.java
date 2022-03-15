package com.estudos.protocolo.service;

import java.util.List;

import com.estudos.protocolo.domain.Protocolo;
import com.estudos.protocolo.dto.ProtocoloDto;

/**
 * Serviços implementados para a gestão de protocolos
 * 
 * @author guilherme
 *
 */
public interface ProtocoloService {

	/**
	 * Cria um novo protocolo gerando uma chave aleatória
	 * 
	 * @param dto
	 * @return
	 */
	public Protocolo criar(ProtocoloDto dto);

	/**
	 * Lista todos os protocolos
	 * 
	 * @return
	 */
	public List<Protocolo> listar();

	/**
	 * Atualiza um determinado protocolo
	 * 
	 * @param dto
	 * @param id
	 * @return
	 */
	public Protocolo atualizar(ProtocoloDto dto, final Long id);

	/**
	 * Apaga um determinado protocolo
	 * 
	 * @param id
	 */
	public void apagar(Long id);

	/**
	 * Lista um determinado protocolo
	 * 
	 * @param id
	 * @return
	 */
	public Protocolo listar(Long id);
}
