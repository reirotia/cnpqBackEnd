package br.cnpq.desafio.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.cnpq.desafio.domain.Funcionario;
import br.cnpq.desafio.domain.Usuario;

@Repository
public interface FuncionarioRespository extends JpaRepository<Funcionario, Integer> {

	//Optional<Funcionario> findByCon(String nome);
}
