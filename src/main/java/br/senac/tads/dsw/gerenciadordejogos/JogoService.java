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

    private Map<String, JogoDto> mapJogos = new ConcurrentHashMap<>();

    @PostConstruct
    public void init(){
        mapJogos.put("Forza Horizon 67", new JogoDto(contador.incrementAndGet(), "Forza Horizon 67", LocalDate.parse("2026-10-20"), "Xbox", true, "teste"));
        mapJogos.put("GOW Ragnarok", new JogoDto(contador.incrementAndGet(), "GOW Ragnarok", LocalDate.parse("2024-10-20"), "playstation" , true, "teste"));
        mapJogos.put("Fortnite", new JogoDto(contador.incrementAndGet(), "Fortnite", LocalDate.parse("2017-10-20"), "qualquer",true, "teste"));
    }

    public List<JogoDto> obterJogos(){
        return new ArrayList<>(mapJogos.values());
    }

    public Optional<JogoDto> obterJogo(String titulo){
        return Optional.ofNullable(mapJogos.get(titulo));
    }

    public JogoDto incluirNovoJogo(JogoDto jogoDto){

        jogoDto.setId(contador.incrementAndGet());
        mapJogos.put(jogoDto.getTitulo(), jogoDto);
        return jogoDto;
    }

	public JogoDto alterarJogo(String titulo, JogoAlteracaoDto jogoAlteracaoDto){
		if (!mapJogos.containsKey(titulo)){
			throw new NaoEncontradoException("Jogo " + titulo + " não encontrado");
		}

		JogoDto jogoOriginal = mapJogos.get(titulo);
		jogoOriginal.setDataLancamento(jogoAlteracaoDto.getDataLancamento());
		jogoOriginal.setDisponivel(jogoAlteracaoDto.getDisponivel());
		jogoOriginal.setPlataforma(jogoAlteracaoDto.getPlataforma());
		jogoOriginal.setObservacoes(jogoAlteracaoDto.getObservacoes());

		return jogoOriginal;

	}

	public void removerJogo(String titulo){
		if (!mapJogos.containsKey(titulo)){
			throw new NaoEncontradoException("Jogo " + titulo + " não encontrado");
		}

		mapJogos.remove(titulo);
	}


}
