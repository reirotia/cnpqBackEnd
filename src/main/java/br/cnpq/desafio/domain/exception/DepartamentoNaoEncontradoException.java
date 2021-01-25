package br.cnpq.desafio.domain.exception;

public class DepartamentoNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public DepartamentoNaoEncontradoException(String mensagem) {
			super(mensagem);
		}

	public DepartamentoNaoEncontradoException(Integer id) {
			this(String.format("Não existe departamento com código %d",id));
		}

}