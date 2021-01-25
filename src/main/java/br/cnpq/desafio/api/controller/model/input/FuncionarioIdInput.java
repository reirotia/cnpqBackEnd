package br.cnpq.desafio.api.controller.model.input;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioIdInput {


	@NotNull
	private Integer id;
}
