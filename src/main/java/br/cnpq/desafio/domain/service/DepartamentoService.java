package br.cnpq.desafio.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.cnpq.desafio.domain.Departamento;
import br.cnpq.desafio.domain.exception.DepartamentoNaoEncontradoException;
import br.cnpq.desafio.domain.exception.EntidadeEmUsoException;
import br.cnpq.desafio.domain.repository.DepartamentoRepository;

@Service
public class DepartamentoService  {

	private static final String MSG_DEPARTAMENTO_EM_USO 
	= "O departamento de código %d não pode ser removido, pois está em uso";

	
	@Autowired 
	private DepartamentoRepository departamentoRepository;
	
	@Transactional
	public Departamento salvar(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}
	
	public Departamento buscarOuFalhar(Integer id) {
		return departamentoRepository.findById(id)
				.orElseThrow(() -> new DepartamentoNaoEncontradoException(id));
	}
	
	@Transactional
	public void remover(Integer id) {
		try {
			departamentoRepository.deleteById(id);
			} catch(EmptyResultDataAccessException e) {
				throw new DepartamentoNaoEncontradoException(id);
			} catch (DataIntegrityViolationException e ) {
				throw new EntidadeEmUsoException(String.format(MSG_DEPARTAMENTO_EM_USO, id));
			}
	}
}
