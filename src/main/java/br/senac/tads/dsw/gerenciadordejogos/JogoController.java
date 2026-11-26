package br.senac.tads.dsw.gerenciadordejogos;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// essa classe serve para criar os endpoints de cada funcao do crud
@RestController
@RequestMapping("/jogos")
public class JogoController {

    private final JogoService jogoService;

    public JogoController(JogoService jogoService){
        this.jogoService = jogoService;
    }

    @GetMapping
    public List<JogoDto> obterJogos() {
        return jogoService.obterJogos();
    }

    @GetMapping("/{titulo}")
    public JogoDto obterJogo(@PathVariable("titulo") String titulo) {
        Optional<JogoDto> optJogo = jogoService.obterJogo(titulo);
        if(optJogo.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return optJogo.get();
    }

    @PostMapping
    public ResponseEntity<?> incluirJogo(@RequestBody @Valid JogoDto jogoDto){

        jogoService.incluirNovoJogo(jogoDto);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/jogos/{titulo}").buildAndExpand(jogoDto.getTitulo()).toUri();

        return ResponseEntity.created(location).build();

    }

	@PutMapping("/{titulo}")
	public ResponseEntity<?> atualizar(@PathVariable("titulo") String titulo, @RequestBody @Valid JogoAlteracaoDto jogo){
		JogoDto jogoAlterado = jogoService.alterarJogo(titulo, jogo);
		return ResponseEntity.ok().body(jogoAlterado);
	}

	@DeleteMapping("/{titulo}")
	public ResponseEntity<?> remover(@PathVariable("titulo") String titulo){
		jogoService.removerJogo(titulo);
		return ResponseEntity.noContent().build();
	}

	@ExceptionHandler(NaoEncontradoException.class)
	public ResponseEntity<ProblemDetail> tratarExcecao(NaoEncontradoException ex) {
		// ProblemDetail - padrão RFC 7807 para representar erros HTTP
		ProblemDetail pd = ProblemDetail.forStatusAndDetail(
			HttpStatusCode.valueOf(404), ex.getMessage());
		return ResponseEntity.of(pd).build();
	}








}
