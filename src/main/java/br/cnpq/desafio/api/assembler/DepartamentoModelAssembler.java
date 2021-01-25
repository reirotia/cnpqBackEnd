package br.cnpq.desafio.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.cnpq.desafio.api.controller.model.DepartamentoModel;
import br.cnpq.desafio.domain.Departamento;

@Component
public class DepartamentoModelAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public DepartamentoModel toDepartamentoModel(Departamento departamento) {
		return modelMapper.map(departamento, DepartamentoModel.class);
	}

	public List<DepartamentoModel> toCollectionModel(List<Departamento> departamentos) {

		return departamentos.stream().map(dep -> toDepartamentoModel(dep)).collect(Collectors.toList());

	}

}
