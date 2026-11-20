package br.senac.tads.dsw.gerenciadordejogos;

public class NaoEncontradoException extends RuntimeException{
	public NaoEncontradoException(String mesagem) {
		super(mesagem);
	}
}
