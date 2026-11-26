package br.senac.tads.dsw.gerenciadordejogos.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senac.tads.dsw.gerenciadordejogos.entidade.JogoEntity;

//  JpaRepository<Entidade, TipoDoId> é uma interface do Spring Data JPA que herda de outras classes
// Ao estendê-la, o repositório ganha automaticamente uma série de operações prontas

@Repository //nem usa, mas é semanticamente bom 
public interface JogoRepository  extends JpaRepository <JogoEntity, Integer>{

    Optional<JogoEntity> findByTitulo(String titulo);

    boolean existsByTitulo(String titulo);

    
}
