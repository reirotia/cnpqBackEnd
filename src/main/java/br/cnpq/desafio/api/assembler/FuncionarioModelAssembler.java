package br.cnpq.desafio.api.assembler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.cnpq.desafio.api.controller.model.FuncionarioModel;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import br.cnpq.desafio.domain.Funcionario;

@Component
public class FuncionarioModelAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public FuncionarioModel toFuncionarioModel(Funcionario funcionario) {
		return modelMapper.map(funcionario, FuncionarioModel.class);
	}
	
	public List<FuncionarioModel> toCollectionModel(List<Funcionario> funcionarios) {
		
		return funcionarios.stream()
				.map(funcionario -> toFuncionarioModel(funcionario))
				.collect(Collectors.toList());
				
				
	}

}
