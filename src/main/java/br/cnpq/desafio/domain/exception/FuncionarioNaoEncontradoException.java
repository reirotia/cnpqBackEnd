package br.cnpq.desafio.domain.exception;

public class FuncionarioNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public FuncionarioNaoEncontradoException(String mensagem) {
			super(mensagem);
		}

	public FuncionarioNaoEncontradoException(Integer id) {
			this(String.format("Não existe departamento com código %d",id));
		}

}