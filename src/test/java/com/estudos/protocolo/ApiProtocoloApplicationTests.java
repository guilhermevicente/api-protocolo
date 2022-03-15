package com.estudos.protocolo;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.estudos.protocolo.domain.Protocolo;
import com.estudos.protocolo.dto.ProtocoloDto;
import com.estudos.protocolo.service.ProtocoloService;
import com.estudos.protocolo.service.impl.ProtocoloServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class ApiProtocoloApplicationTests {

	@Autowired
	private ProtocoloService service;

	@TestConfiguration
	static class EmployeeServiceImplTestContextConfiguration {

		@Bean
		public ProtocoloService service() {
			return new ProtocoloServiceImpl();
		}
	}

	@BeforeEach
	public void antesDeCadaTest() {
		service.listar().forEach(p -> {
			service.apagar(p.getId());
		});
	}

	@Test
	void criarProtocolo() {
		final ProtocoloDto dto = TestFactory.getProtocolo();
		final Protocolo criado = service.criar(dto);

		Assert.assertEquals(criado.getAutor(), dto.getAutor());
		Assert.assertEquals(criado.getTipo(), dto.getTipo());
		Assert.assertEquals(criado.getUsuario(), dto.getUsuario());
		Assert.assertNotNull(criado.getId());
		Assert.assertNotNull(criado.getChave());
		Assert.assertNotNull(criado.getDocumentos());
	}

	@Test
	void atualizarProtocolo() {
		final Protocolo criado = service.criar(TestFactory.getProtocolo());

		final ProtocoloDto dto = TestFactory.getProtocolo();
		dto.setAutor("autor-alterado");

		final Protocolo atualizado = service.atualizar(dto, criado.getId());

		Assert.assertEquals("autor-alterado", atualizado.getAutor());
	}

	@Test
	void atualizarProtocoloInexistente() {
		final Protocolo criado = service.criar(TestFactory.getProtocolo());

		final ProtocoloDto dto = TestFactory.getProtocolo();
		dto.setAutor("autor-alterado");

		final Protocolo atualizado = service.atualizar(dto, criado.getId() + 1);

		Assert.assertEquals("autor-alterado", atualizado.getAutor());
	}

	@Test
	void buscarProtocolos() {
		service.criar(TestFactory.getProtocolo());
		service.criar(TestFactory.getProtocolo());
		service.criar(TestFactory.getProtocolo());

		final List<Protocolo> listados = service.listar();

		Assert.assertEquals(3, listados.size());
	}

	@Test
	void buscarPorId() {
		final Protocolo criado = service.criar(TestFactory.getProtocolo());
		final Protocolo listado = service.listar(criado.getId());

		Assert.assertEquals(criado, listado);
	}

	@Test
	void apagar() {
		final Protocolo criado = service.criar(TestFactory.getProtocolo());

		Assert.assertNotNull(criado);

		final Long id = criado.getId();
		service.apagar(id);
		final Protocolo buscado = service.listar(id);

		Assert.assertNull(buscado);
	}
}
