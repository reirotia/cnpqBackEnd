package br.cnpq.desafio.domain.exception;

public class PontoNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public PontoNaoEncontradoException(String mensagem) {
			super(mensagem);
		}

	public PontoNaoEncontradoException(Integer id) {
			this(String.format("Não existe Registro de ponto com código %d",id));
		}

}