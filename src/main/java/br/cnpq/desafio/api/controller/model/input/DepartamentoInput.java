package br.cnpq.desafio.api.controller.model.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartamentoInput {

	@NotBlank
	private String nome;
}
