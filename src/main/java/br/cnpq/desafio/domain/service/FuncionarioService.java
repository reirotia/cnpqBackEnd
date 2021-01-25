package br.cnpq.desafio.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.cnpq.desafio.domain.Departamento;
import br.cnpq.desafio.domain.Funcao;
import br.cnpq.desafio.domain.Funcionario;
import br.cnpq.desafio.domain.exception.EntidadeEmUsoException;
import br.cnpq.desafio.domain.exception.FuncaoNaoEncontradoException;
import br.cnpq.desafio.domain.exception.FuncionarioNaoEncontradoException;
import br.cnpq.desafio.domain.repository.FuncionarioRespository;

@Service
public class FuncionarioService {

	private static final String MSG_FUNCAO_EM_USO = "A função de código %d não pode ser removida, pois está em uso";

	@Autowired
	private FuncionarioRespository funcionarioRepo;

	@Autowired
	private DepartamentoService departamentoService;

	@Autowired
	private FuncaoService funcaoService;


	@Transactional
	public Funcionario salvar(Funcionario funcionario) {

		Integer departamentoId = funcionario.getDepartamento().getId();
		Departamento departamento = departamentoService.buscarOuFalhar(departamentoId);
		funcionario.setDepartamento(departamento);
		
		Integer funcaoId = funcionario.getFuncao().getId();
		Funcao funcao = funcaoService.buscarOuFalhar(funcaoId);
		funcionario.setFuncao(funcao);
		
		
		return funcionarioRepo.save(funcionario);
	}

	public Funcionario buscarOuFalhar(Integer id) {
		return funcionarioRepo.findById(id).orElseThrow(() -> new FuncionarioNaoEncontradoException(id));
	}

	@Transactional
	public void remover(Integer id) {
		try {
			funcionarioRepo.deleteById(id);
			funcionarioRepo.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new FuncaoNaoEncontradoException(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_FUNCAO_EM_USO, id));
		}

	}

}
