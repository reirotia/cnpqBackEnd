package br.cnpq.desafio.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.cnpq.desafio.domain.UsuarioLogin;

@Repository
public interface UsuarioRepository  extends JpaRepository<UsuarioLogin, Integer>{

	Optional<UsuarioLogin> findByUsername(String username);
	
	
}
