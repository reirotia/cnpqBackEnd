package br.cnpq.desafio.api.controller.model.input;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioInput {

	@NotBlank
	private String nome;
	@NotBlank
	@CPF
	private String cpf;
	@Email
	private String email;
	private String telefone;
	private EnderecoInput endereco;
	@Valid
	@NotNull
	private FuncaoIdInput funcao;

	@Valid
	@NotNull
	private DepartamentoIdInput departamento;

}
