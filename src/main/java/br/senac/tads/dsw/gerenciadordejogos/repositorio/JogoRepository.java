package br.senac.tads.dsw.gerenciadordejogos.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senac.tads.dsw.gerenciadordejogos.entidade.JogoEntity;

@Repository //nem usa, mas é legal
public interface JogoRepository  extends JpaRepository <JogoEntity, Integer>{

    Optional<JogoRepository> findByTitulo(String titulo);

    boolean existsByTitulo(String titulo);

    
}
