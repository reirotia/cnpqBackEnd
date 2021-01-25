package br.cnpq.desafio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.cnpq.desafio.domain.Funcao;

@Repository
public interface FuncaoRepository extends JpaRepository<Funcao, Integer> {

}
