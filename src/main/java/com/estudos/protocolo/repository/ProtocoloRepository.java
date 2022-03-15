package com.estudos.protocolo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudos.protocolo.domain.Protocolo;

public interface ProtocoloRepository extends JpaRepository<Protocolo, Long> {
}
