package br.cnpq.desafio.domain.exception;

public class FuncaoNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public FuncaoNaoEncontradoException(String mensagem) {
			super(mensagem);
		}

	public FuncaoNaoEncontradoException(Integer id) {
			this(String.format("Não existe um cadastro de Função com código %d",id));
		}

}