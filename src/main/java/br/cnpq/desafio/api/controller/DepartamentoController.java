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

import br.cnpq.desafio.api.assembler.DepartamentoInputDisassembler;
import br.cnpq.desafio.api.assembler.DepartamentoModelAssembler;
import br.cnpq.desafio.api.controller.model.DepartamentoModel;
import br.cnpq.desafio.api.controller.model.input.DepartamentoInput;
import br.cnpq.desafio.domain.Departamento;
import br.cnpq.desafio.domain.repository.DepartamentoRepository;
import br.cnpq.desafio.domain.service.DepartamentoService;

@RestController
@RequestMapping("/departamentos")
@CrossOrigin("http://localhost:4200")
public class DepartamentoController {

	@Autowired
	private DepartamentoRepository departamentoRepository;
	@Autowired
	private DepartamentoModelAssembler departamentoModelAssembler; 
	@Autowired
	private DepartamentoService departamentoService;
	@Autowired
	private DepartamentoInputDisassembler departamentoInputDisassembler;
	@GetMapping
	public List<DepartamentoModel> listar(){
		return departamentoModelAssembler.toCollectionModel(departamentoRepository.findAll()); 
	}
	
	@GetMapping("/{id}")
	public DepartamentoModel buscar(@PathVariable Integer id) {
		return departamentoModelAssembler.toDepartamentoModel(departamentoService.buscarOuFalhar(id));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DepartamentoModel salvar(@RequestBody @Valid DepartamentoInput departamentoInput ) {
		Departamento departamento = departamentoInputDisassembler.toDomainObject(departamentoInput);
		return departamentoModelAssembler.toDepartamentoModel(departamentoService.salvar(departamento));
	}
	
	@PutMapping("/{id}")
	public DepartamentoModel Atualizar(@PathVariable Integer id ,@RequestBody @Valid DepartamentoInput departamentoInput ) {
		Departamento departamento = departamentoService.buscarOuFalhar(id);
		departamentoInputDisassembler.copytoDomainObject(departamentoInput, departamento);
		return departamentoModelAssembler.toDepartamentoModel(departamentoService.salvar(departamento));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Integer id) {
		departamentoService.remover(id);
	}
	
}
