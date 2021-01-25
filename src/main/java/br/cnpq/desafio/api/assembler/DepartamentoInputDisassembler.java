package br.cnpq.desafio.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.cnpq.desafio.api.controller.model.input.DepartamentoInput;
import br.cnpq.desafio.domain.Departamento;

@Component
public class DepartamentoInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Departamento toDomainObject(DepartamentoInput DepartamentoInput) {
		return modelMapper.map(DepartamentoInput, Departamento.class);
	}
	
	public void copytoDomainObject(DepartamentoInput departamentoInput, Departamento departamento) {
		modelMapper.map(departamentoInput, departamento);
	}
}
