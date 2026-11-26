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

//mapimpl serve para manipulacao e armazenamento de dados locais com o map, nao é utilizado no momento

@Service
public class JogoServiceMapImpl implements JogoService{

    private AtomicInteger contador = new AtomicInteger(0);

    private Map<String, JogoDto> mapJogos = new ConcurrentHashMap<>();

    @PostConstruct
    public void init(){
        mapJogos.put("Forza Horizon 67", new JogoDto(contador.incrementAndGet(), "Forza Horizon 67", 2025, "Xbox", true, "teste"));
        mapJogos.put("GOW Ragnarok", new JogoDto(contador.incrementAndGet(), "GOW Ragnarok", 2024, "playstation" , true, "teste"));
        mapJogos.put("Fortnite", new JogoDto(contador.incrementAndGet(), "Fortnite", 2017, "qualquer",true, "teste"));
    }

    @Override
    public List<JogoDto> obterJogos(){
        return new ArrayList<>(mapJogos.values());
    }

    @Override
    public Optional<JogoDto> obterJogo(String titulo){
        return Optional.ofNullable(mapJogos.get(titulo));
    }

    @Override
    public JogoDto incluirNovoJogo(JogoDto jogoDto){

        jogoDto.setId(contador.incrementAndGet());
        mapJogos.put(jogoDto.getTitulo(), jogoDto);
        return jogoDto;
    }

    @Override
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

    @Override
	public void removerJogo(String titulo){
		if (!mapJogos.containsKey(titulo)){
			throw new NaoEncontradoException("Jogo " + titulo + " não encontrado");
		}

		mapJogos.remove(titulo);
	}


}
