package br.senac.tads.dsw.gerenciadordejogos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service 
public class JogoService {

    private AtomicInteger contador = new AtomicInteger(0);

    private Map<String, Jogo> mapJogos = new ConcurrentHashMap<>();

    @PostConstruct 
    public void init(){
        mapJogos.put("Forza Horizon 67", new Jogo(contador.incrementAndGet(), "Forza Horizon 67", LocalDate.parse("2026-10-20"), "Xbox", true, "teste"));
        mapJogos.put("GOW Ragnarok", new Jogo(contador.incrementAndGet(), "GOW Ragnarok", LocalDate.parse("2024-10-20"), "playstation" , true, "teste"));
        mapJogos.put("Fortnite", new Jogo(contador.incrementAndGet(), "Fortnite", LocalDate.parse("2017-10-20"), "qualquer",true, "teste"));
    }

    public List<Jogo> obterJogos(){
        return new ArrayList<>(mapJogos.values());
    }

    public Optional<Jogo> obterJogo(String titulo){
        return Optional.ofNullable(mapJogos.get(titulo));
    }

 
}
