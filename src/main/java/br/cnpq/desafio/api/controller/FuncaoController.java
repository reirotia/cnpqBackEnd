package br.cnpq.desafio.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.cnpq.desafio.api.assembler.FuncaoInputDisassembler;
import br.cnpq.desafio.api.assembler.FuncaoModelAssembler;
import br.cnpq.desafio.api.controller.model.FuncaoModel;
import br.cnpq.desafio.api.controller.model.input.FuncaoInput;
import br.cnpq.desafio.domain.Funcao;
import br.cnpq.desafio.domain.repository.FuncaoRepository;
import br.cnpq.desafio.domain.service.FuncaoService;

@RestController
@RequestMapping("/funcoes")
@CrossOrigin("http://localhost:4200")
public class FuncaoController {

	@Autowired
	private FuncaoService funcaoService;
	@Autowired
	private FuncaoRepository funcaoRepository;
	@Autowired
	private FuncaoModelAssembler funcaoModelAssembler;
	@Autowired
	private FuncaoInputDisassembler funcaoInputDisassembler;

	@GetMapping
	public List<FuncaoModel> listar() {
		return funcaoModelAssembler.toCollectionModel(funcaoRepository.findAll());
	}

	@GetMapping("/{id}")
	public FuncaoModel buscar(@PathVariable Integer id) {
		return funcaoModelAssembler.toFuncaoModel((funcaoService.buscarOuFalhar(id)));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public FuncaoModel salvar(@RequestBody @Valid FuncaoInput funcaoInput) {
		Funcao funcao = funcaoInputDisassembler.toDomainObject(funcaoInput);
		return funcaoModelAssembler.toFuncaoModel(funcaoService.salvar(funcao));
	}

	@PutMapping("/{id}")
	public FuncaoModel atualizar(@PathVariable Integer id, @RequestBody @Valid FuncaoInput funcaoInput) {
		Funcao funcaoAtual = funcaoService.buscarOuFalhar(id);
		funcaoInputDisassembler.copyToDomainObject(funcaoInput, funcaoAtual);
		funcaoAtual = funcaoService.salvar(funcaoAtual);
		return funcaoModelAssembler.toFuncaoModel(funcaoAtual);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Integer id) {
		funcaoService.excluir(id);
	}

}
