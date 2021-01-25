package br.cnpq.desafio.domain;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Funcionario {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	private OffsetDateTime dataNascimento;
	private String email;
	private String telefone;

	/*
	@Embedded
	private Endereco endereco;
	 */
	@ManyToOne
	@JoinColumn(nullable = false)
	private Funcao funcao;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Departamento departamento;

	@OneToMany(mappedBy = "funcionario")
	private List<Ponto> produtos = new ArrayList<>();
	
	
}
