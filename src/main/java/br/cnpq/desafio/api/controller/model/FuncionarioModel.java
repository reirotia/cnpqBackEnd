package br.cnpq.desafio.api.controller.model;

import br.cnpq.desafio.domain.Funcao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioModel {

	
	private Integer id;
	private String nome;
	private String email;
	private String telefone;
	
	private EnderecoModel endereco;
	private DepartamentoModel departamento;
	private Funcao funcao; 
}
