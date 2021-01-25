package br.cnpq.desafio.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cnpq.desafio.domain.Ponto;
import br.cnpq.desafio.domain.exception.PontoNaoEncontradoException;
import br.cnpq.desafio.domain.repository.PontoRepository;

@Service
public class PontoService {


	@Autowired
	private PontoRepository pontoRepository;

	@Transactional
	public Ponto salvar(Ponto ponto) {
		return pontoRepository.save(ponto);
	}

	public Ponto buscarOuFalhar(Integer id) {
		return pontoRepository.findById(id).orElseThrow(() -> new PontoNaoEncontradoException(id));
	}

}
