package br.cnpq.desafio.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.cnpq.desafio.domain.Funcionario;
import br.cnpq.desafio.domain.Ponto;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Repository
public interface PontoRepository extends JpaRepository<Ponto, Integer> {

	@Query(" from Ponto where funcionario.id = :funcionario and id = :ponto")
	Optional<Ponto> findById(@Param("funcionario") Integer funcionarioId, 
			@Param("ponto") Integer pontoId);
	
	List<Ponto> findByFuncionario(Funcionario funcionario);
	/*
	List<Ponto> findByNome(String nome);
	*/
	
}
