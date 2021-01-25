package br.cnpq.desafio.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.cnpq.desafio.api.controller.model.FuncaoModel;
import br.cnpq.desafio.domain.Funcao;

@Component
public class FuncaoModelAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public FuncaoModel toFuncaoModel(Funcao funcao) {
		return modelMapper.map(funcao, FuncaoModel.class);
	}

	public List<FuncaoModel> toCollectionModel(List<Funcao> funcoes) {

		return funcoes.stream().map(funcao -> toFuncaoModel(funcao)).collect(Collectors.toList());

	}

}
