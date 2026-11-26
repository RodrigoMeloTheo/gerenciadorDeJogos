package br.senac.tads.dsw.gerenciadordejogos;

import java.util.List;
import java.util.Optional;
///
/// Jogo service é a interface que obriga que quem a implemente, tenha as funcoes abaixo, no caso os services, que realiza essas operacoes
/// 
public interface JogoService {

    List<JogoDto> obterJogos();
    
    Optional<JogoDto> obterJogo(String titulo);
    
    JogoDto incluirNovoJogo(JogoDto jogo);
    
    JogoDto alterarJogo(String titulo, JogoAlteracaoDto jogoAlteracao);

    void removerJogo(String titulo);



    



}
