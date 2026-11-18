package br.senac.tads.dsw.gerenciadordejogos;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/jogos")
public class JogoController {

    private final JogoService jogoService;

    public JogoController(JogoService jogoService){
        this.jogoService = jogoService;
    }

    @GetMapping
    public List<Jogo> obterJogos() {
        return jogoService.obterJogos();
    }

    @GetMapping("/{titulo}")
    public Jogo obterJogo(@PathVariable("titulo") String titulo) {
        Optional<Jogo> optJogo = jogoService.obterJogo(titulo);
        if(optJogo.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return optJogo.get();
    }

    @PostMapping
    public ResponseEntity<?> incluirJogo(@RequestBody @Valid Jogo jogo){

        jogoService.incluirNovoJogo(jogo);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/jogos/{titulo}").buildAndExpand(jogo.getTitulo()).toUri();

        return ResponseEntity.created(location).build();

    }
    

  
    
    
    




}
