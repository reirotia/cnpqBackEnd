package br.cnpq.desafio.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.cnpq.desafio.api.controller.model.input.FuncionarioInput;
import br.cnpq.desafio.domain.Funcionario;

@Component
public class FuncionarioInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Funcionario toDomainObject(FuncionarioInput funcionarioInput) {
		return modelMapper.map(funcionarioInput, Funcionario.class);
	}
	
	public void copytoDomainObject(FuncionarioInput funcionarioInput, Funcionario funcionario) {
		modelMapper.map(funcionarioInput, funcionario);
	}
}
