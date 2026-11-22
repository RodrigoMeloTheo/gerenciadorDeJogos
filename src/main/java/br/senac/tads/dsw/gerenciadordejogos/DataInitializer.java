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
            JogoEntity j1 = new JogoEntity();
            j1.setTitulo("Resident Evil 2 Remake");
            j1.setDataLancamento(LocalDate.parse("2000-10-20"));
            j1.setPlataforma("Xbox, Playstation, PC");
            j1.setDisponivel(true);
            j1.setObservacoes("teste");
            jogoRepository.save(j1);

            
            JogoEntity j2 = new JogoEntity();
            j2.setTitulo("Elden Ring");
            j2.setDataLancamento(LocalDate.parse("2020-10-20"));
            j2.setPlataforma("Xbox, Playstation, PC");
            j2.setDisponivel(true);
            j2.setObservacoes("");
            jogoRepository.save(j2);


            
            JogoEntity j3 = new JogoEntity();
            j3.setTitulo("Castlevania");
            j3.setDataLancamento(LocalDate.parse("1999-10-20"));
            j3.setPlataforma("Xbox, Playstation, PC, nintendo");
            j3.setDisponivel(false);
            j3.setObservacoes(" ");
            jogoRepository.save(j3);


         }
    }


}
