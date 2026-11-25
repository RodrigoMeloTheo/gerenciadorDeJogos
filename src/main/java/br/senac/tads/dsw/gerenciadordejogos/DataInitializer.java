package br.senac.tads.dsw.gerenciadordejogos;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.senac.tads.dsw.gerenciadordejogos.entidade.JogoEntity;
import br.senac.tads.dsw.gerenciadordejogos.repositorio.JogoRepository;

@Component 
public class DataInitializer implements CommandLineRunner{
    private final JogoRepository jogoRepository;

    public DataInitializer(JogoRepository jogoRepository){
        this.jogoRepository = jogoRepository;
    }

    @Override 
    @Transactional 
    public void run(String... args) throws Exception{
         if (jogoRepository.count() == 0){
          


         }
    }


}
