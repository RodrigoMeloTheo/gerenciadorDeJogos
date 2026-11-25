package br.senac.tads.dsw.gerenciadordejogos;

import java.lang.StackWalker.Option;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.TypeRegistration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.senac.tads.dsw.gerenciadordejogos.entidade.JogoEntity;
import br.senac.tads.dsw.gerenciadordejogos.repositorio.JogoRepository;

@Primary 
@Service 
public class JogoServiceJpaImpl implements JogoService{

    private final JogoRepository jogoRepository;

    public JogoServiceJpaImpl(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    //conversao de entity para dto

    private JogoDto toDto(JogoEntity entity){
        JogoDto dto = new JogoDto();
        dto.setId(entity.getId());
        dto.setTitulo(entity.getTitulo());
        dto.setDataLancamento(entity.getDataLancamento());
        dto.setPlataforma(entity.getPlataforma());
        dto.setDisponivel(entity.getDisponivel());
        dto.setObservacoes(entity.getObservacoes());

        return dto;


    }

    //dto para entity (para insersao)

    private JogoEntity toEntity(JogoDto dto){
        JogoEntity entity = new JogoEntity();

        entity.setTitulo(dto.getTitulo());
        entity.setDataLancamento(dto.getDataLancamento());
        entity.setPlataforma(dto.getPlataforma());
        entity.setDisponivel(dto.getDisponivel());
        entity.setObservacoes(dto.getObservacoes());
        
        return entity;
    }

    @Override 
    @Transactional (readOnly = true) //otimiza leituras
    public List<JogoDto> obterJogos(){
        List<JogoDto> resultado = new ArrayList<>();

        for(JogoEntity entity : jogoRepository.findAll()){
            JogoDto dto = toDto(entity);
            resultado.add(dto);    
        }
        return resultado;
    }

    @Override 
    @Transactional (readOnly = true)
    public Optional<JogoDto> obterJogo(String titulo){
        Optional<JogoEntity> optEntity = jogoRepository.findByTitulo(titulo);
        if(optEntity.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(toDto(optEntity.get()));
    }

    @Override 
    @Transactional
    public JogoDto incluirNovoJogo(JogoDto dto){
        JogoEntity entity = toEntity(dto);
        
        if (!jogoRepository.existsByTitulo(dto.getTitulo())) {
            JogoEntity salva = jogoRepository.save(entity);
        return toDto(salva);            
        }
         throw new NaoEncontradoException("o jogo "+ dto.getTitulo() + " ja está cadastrado");  
        
    }


    @Override 
    @Transactional
    public JogoDto alterarJogo(String titulo, JogoAlteracaoDto jogoAlteracao){
        Optional<JogoEntity> optEntity = jogoRepository.findByTitulo(titulo);
        if(optEntity.isEmpty()){
            throw new NaoEncontradoException("jogo "+ titulo+ " Não encontrado");  
        }
        JogoEntity entity = optEntity.get();

        entity.setDataLancamento(jogoAlteracao.getDataLancamento());
        entity.setPlataforma(jogoAlteracao.getPlataforma());
        entity.setDisponivel(jogoAlteracao.getDisponivel());
        entity.setObservacoes(jogoAlteracao.getObservacoes());


        JogoEntity salva = jogoRepository.save(entity);
        return toDto(salva);
    }

    @Override 
    @Transactional 
    public void removerJogo(String titulo){
        Optional<JogoEntity> optEntity = jogoRepository.findByTitulo(titulo);
        if(optEntity.isEmpty()){
            throw new NaoEncontradoException("jogo "+ titulo+ " Não encontrado");
        }
        JogoEntity entity = optEntity.get();
        jogoRepository.delete(entity); //delete no banco
    }

}
