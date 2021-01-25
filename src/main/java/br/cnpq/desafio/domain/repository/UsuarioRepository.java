package br.cnpq.desafio.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.cnpq.desafio.domain.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Integer>{

	Optional<Usuario> findByUsername(String username);
	
	
}
