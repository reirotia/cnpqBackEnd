package br.cnpq.desafio.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.cnpq.desafio.api.controller.model.PontoModel;
import br.cnpq.desafio.domain.Ponto;

@Component
public class PontoModelAssembler {

	@Autowired 
	private ModelMapper modelMapper;
	
	public PontoModel toPontoModel(Ponto registroPonto ) {
		return modelMapper.map(registroPonto, PontoModel.class);
	}
	
	public List<PontoModel> toCollectionModel(List<Ponto> pontos) {
		return pontos.stream()
				.map(ponto -> toPontoModel(ponto))
				.collect(Collectors.toList());
	}
}
