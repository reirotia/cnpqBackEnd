package br.cnpq.desafio.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.cnpq.desafio.api.controller.model.input.PontoInput;
import br.cnpq.desafio.domain.Ponto;

@Component
public class PontoInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Ponto toDomainObject(PontoInput pontoInput) {
		return modelMapper.map(pontoInput, Ponto.class);
	}
	
	
	public void copyToDomain(PontoInput pontoInput, Ponto ponto) {
		modelMapper.map(pontoInput, ponto);
	}
	
	
}
