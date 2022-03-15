package com.estudos.protocolo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.protocolo.domain.Protocolo;
import com.estudos.protocolo.dto.ProtocoloDto;
import com.estudos.protocolo.mapper.ProtocoloMapper;
import com.estudos.protocolo.repository.ProtocoloRepository;
import com.estudos.protocolo.service.ProtocoloService;

@Service
public class ProtocoloServiceImpl implements ProtocoloService {

	@Autowired
	private ProtocoloMapper mapper;

	@Autowired
	private ProtocoloRepository repository;

	@Override
	public Protocolo criar(final ProtocoloDto dto) {
		final Protocolo novo = mapper.mapear(dto);
		novo.setDtHrCadastro(LocalDateTime.now());
		novo.setChave(UUID.randomUUID().toString());
		return repository.save(novo);
	}

	@Override
	public List<Protocolo> listar() {
		return repository.findAll();
	}

	@Override
	public Protocolo atualizar(final ProtocoloDto dto, final Long id) {
		return repository.findById(id).map(p -> {
			p.setAutor(dto.getAutor());
			p.setTipo(dto.getTipo());
			return repository.save(p);
		}).orElseGet(() -> {
			return criar(dto);
		});
	}

	@Override
	public void apagar(final Long id) {
		repository.deleteById(id);
	}

	@Override
	public Protocolo listar(final Long id) {
		final Optional<Protocolo> protocoloOpt = repository.findById(id);
		if (protocoloOpt.isPresent())
			return protocoloOpt.get();
		return null;
	}
}
