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

import br.cnpq.desafio.api.assembler.FuncionarioInputDisassembler;
import br.cnpq.desafio.api.assembler.FuncionarioModelAssembler;
import br.cnpq.desafio.api.controller.model.FuncionarioModel;
import br.cnpq.desafio.api.controller.model.input.FuncionarioInput;
import br.cnpq.desafio.domain.Funcionario;
import br.cnpq.desafio.domain.exception.DepartamentoNaoEncontradoException;
import br.cnpq.desafio.domain.exception.FuncaoNaoEncontradoException;
import br.cnpq.desafio.domain.exception.NegocioException;
import br.cnpq.desafio.domain.repository.FuncionarioRespository;
import br.cnpq.desafio.domain.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
@CrossOrigin("http://localhost:4200")
public class FuncionarioController {

	@Autowired
	private FuncionarioRespository funcionarioRepo;
	
	
	@Autowired
	private FuncionarioModelAssembler funcionarioModelAssembler;
	@Autowired
	private FuncionarioInputDisassembler funcionarioInputDisassembler;
	
	@Autowired
	private FuncionarioService funcionarioService;

	@GetMapping
	public List<FuncionarioModel> listar() {
		return funcionarioModelAssembler.toCollectionModel(funcionarioRepo.findAll());
	}

	@GetMapping("/{id}")
	public FuncionarioModel buscar(@PathVariable Integer id) {
		return funcionarioModelAssembler.toFuncionarioModel(funcionarioService.buscarOuFalhar(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public FuncionarioModel salvar(@RequestBody @Valid FuncionarioInput funcionarioInput) {
		try {
			Funcionario funcionario = funcionarioInputDisassembler.toDomainObject(funcionarioInput);
			return funcionarioModelAssembler.toFuncionarioModel(funcionarioService.salvar(funcionario));
		} catch (DepartamentoNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		} catch (FuncaoNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
		

	}
	
	@PutMapping("/{id}")
	public FuncionarioModel atualizar(@PathVariable  Integer id, @RequestBody @Valid FuncionarioInput funcionarioInput) {
		try {
		Funcionario funcionarioAtual = funcionarioService.buscarOuFalhar(id);
		funcionarioInputDisassembler.copytoDomainObject(funcionarioInput, funcionarioAtual);
		return funcionarioModelAssembler.toFuncionarioModel(
				funcionarioService.salvar(funcionarioAtual));
		} catch (FuncaoNaoEncontradoException e ) {
			throw new NegocioException(e.getMessage());
		} catch (DepartamentoNaoEncontradoException e) {
			throw new NegocioException(e.getLocalizedMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Integer id) {
			funcionarioService.remover(id);
	}
	
	
}
