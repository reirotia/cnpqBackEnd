package br.cnpq.desafio.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.cnpq.desafio.domain.Funcao;
import br.cnpq.desafio.domain.exception.EntidadeEmUsoException;
import br.cnpq.desafio.domain.exception.FuncaoNaoEncontradoException;
import br.cnpq.desafio.domain.repository.FuncaoRepository;

@Service
public class FuncaoService {

	private static final String MSG_FUNCAO_EM_USO 
	= "A funcção de código %d não pode ser removido, pois está em uso";

	@Autowired
	private FuncaoRepository funcaoRepository;
	
	@Transactional
	public Funcao salvar(Funcao funcao) {
		return funcaoRepository.save(funcao);
	}
	
	public Funcao buscarOuFalhar(Integer id) {
		return funcaoRepository.findById(id).orElseThrow(
				() -> new FuncaoNaoEncontradoException(id));
	}
	
	@Transactional
	public void excluir (Integer id) {
		try {
		funcaoRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new FuncaoNaoEncontradoException(id);
		} catch (DataIntegrityViolationException e ) {
			throw new EntidadeEmUsoException(String.format(MSG_FUNCAO_EM_USO, id));
		}
	}
}
