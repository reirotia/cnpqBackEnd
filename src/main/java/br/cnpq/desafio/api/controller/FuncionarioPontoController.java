package br.cnpq.desafio.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.cnpq.desafio.api.assembler.PontoInputDisassembler;
import br.cnpq.desafio.api.assembler.PontoModelAssembler;
import br.cnpq.desafio.api.controller.model.PontoModel;
import br.cnpq.desafio.api.controller.model.input.PontoInput;
import br.cnpq.desafio.domain.Funcionario;
import br.cnpq.desafio.domain.Ponto;
import br.cnpq.desafio.domain.repository.PontoRepository;
import br.cnpq.desafio.domain.service.FuncionarioService;
import br.cnpq.desafio.domain.service.PontoService;

@RestController
@RequestMapping(value =  "/funcionarios/{id}/pontos")
@CrossOrigin("http://localhost:4200")
public class FuncionarioPontoController {
	
	@Autowired
	private PontoRepository pontoRepository;
	
	@Autowired
	private PontoService pontoService;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private PontoModelAssembler pontoModelAssembler;
	
	@Autowired
	private PontoInputDisassembler pontoInputDisassembler;
	
	@GetMapping
	public List<PontoModel> listar(@PathVariable Integer id) {
		Funcionario funcionario = funcionarioService.buscarOuFalhar(id);
		
		List<Ponto> todosPontos =  pontoRepository.findByFuncionario(funcionario);
		
		return pontoModelAssembler.toCollectionModel(todosPontos);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PontoModel adicionar(@PathVariable Integer id,
			@RequestBody @Valid PontoInput pontoInput) {
		Funcionario funcionario = funcionarioService.buscarOuFalhar(id);
		
		Ponto ponto = pontoInputDisassembler.toDomainObject(pontoInput);
		ponto.setFuncionario(funcionario);
		
		ponto = pontoService.salvar(ponto);
		
		return pontoModelAssembler.toPontoModel(ponto);
	}

}
