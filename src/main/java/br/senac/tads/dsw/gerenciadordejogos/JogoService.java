package br.senac.tads.dsw.gerenciadordejogos;

import java.util.List;
import java.util.Optional;

public interface JogoService {

    List<JogoDto> obterJogos();
    
    Optional<JogoDto> obterJogo(String titulo);
    
    JogoDto incluirNovoJogo(JogoDto jogo);
    
    JogoDto alterarJogo(String titulo, JogoAlteracaoDto jogoAlteracao);

    void removerJogo(String titulo);



    



}
