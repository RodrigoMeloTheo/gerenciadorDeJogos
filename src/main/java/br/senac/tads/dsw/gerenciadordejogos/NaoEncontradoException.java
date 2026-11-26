package br.senac.tads.dsw.gerenciadordejogos;

// naoencontrado exception serve tratamento de erro, quando o sistema detecta um erro ele retorna uma resposta 404(nao encontrado), a funcao no controller trata a excessao e tambem retorna uma mensagem para ser exibida no frontend
public class NaoEncontradoException extends RuntimeException{
	public NaoEncontradoException(String mesagem) {
		super(mesagem);
	}
}
