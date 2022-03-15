package com.estudos.protocolo.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.protocolo.domain.Protocolo;
import com.estudos.protocolo.dto.ProtocoloDto;
import com.estudos.protocolo.service.ProtocoloService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/protocolos")
public class ProtocoloController {

	@Autowired
	private ProtocoloService service;

	@ApiOperation(value = "Cria um novo protocolo")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Protocolo criado"),
			@ApiResponse(code = 500, message = "Erro interno do sistema") })
	@PostMapping
	public ResponseEntity<Protocolo> registrar(@RequestBody final ProtocoloDto dto) {
		final Protocolo response = service.criar(dto);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Lista todos os protocolos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Listagem realizada com sucesso"),
			@ApiResponse(code = 404, message = "Não há protocolos cadastrados"),
			@ApiResponse(code = 500, message = "Erro interno do sistema") })
	@GetMapping
	public ResponseEntity<List<Protocolo>> listar() {
		final List<Protocolo> protocolos = service.listar();
		if (protocolos.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(protocolos, HttpStatus.OK);
	}

	@ApiOperation(value = "Lista um determinado protocolo")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Listagem realizada com sucesso"),
			@ApiResponse(code = 404, message = "Não há protocolos cadastrados"),
			@ApiResponse(code = 500, message = "Erro interno do sistema") })
	@GetMapping("/{id}")
	public ResponseEntity<Protocolo> listar(@PathVariable final Long id) {
		final Protocolo protocolo = service.listar(id);
		if (Objects.nonNull(protocolo))
			return new ResponseEntity<>(protocolo, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@ApiOperation(value = "Atualiza um protocolo")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Protocolo atualizado com sucesso"),
			@ApiResponse(code = 201, message = "Cria um novo protocolo"),
			@ApiResponse(code = 500, message = "Erro interno do sistema") })
	@PutMapping("/{id}")
	public ResponseEntity<Protocolo> atualizar(@RequestBody final ProtocoloDto dto, @PathVariable final Long id) {
		final Protocolo protocolo = service.atualizar(dto, id);
		if (id.equals(protocolo.getId())) {
			return new ResponseEntity<>(protocolo, HttpStatus.OK);
		}
		return new ResponseEntity<>(protocolo, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Apaga um protocolo")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Protocolo apagado com sucesso"),
			@ApiResponse(code = 404, message = "Não há protocolos cadastrados"),
			@ApiResponse(code = 500, message = "Erro interno do sistema") })
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> apagar(@PathVariable final Long id) {
		final Protocolo protocolo = service.listar(id);
		if (Objects.nonNull(protocolo)) {
			service.apagar(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
