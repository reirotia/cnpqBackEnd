package br.cnpq.desafio.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.cnpq.desafio.domain.Funcionario;
import br.cnpq.desafio.domain.UsuarioLogin;

@Repository
public interface FuncionarioRespository extends JpaRepository<Funcionario, Integer> {

	List<Funcionario> findTop10ByNomeContaining(String nome);
}
