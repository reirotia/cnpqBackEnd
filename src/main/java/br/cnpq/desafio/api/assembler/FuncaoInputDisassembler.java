package br.cnpq.desafio.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.cnpq.desafio.api.controller.model.input.FuncaoInput;

import br.cnpq.desafio.domain.Funcao;

@Component
public class FuncaoInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Funcao toDomainObject(FuncaoInput funcaoInput) {
		return modelMapper.map(funcaoInput, Funcao.class);
	}
	
	public void copyToDomainObject(FuncaoInput funcaoInput, Funcao funcao) {
		modelMapper.map(funcaoInput, funcao);
	}
}
