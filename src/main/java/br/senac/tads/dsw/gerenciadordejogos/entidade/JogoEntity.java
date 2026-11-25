package br.senac.tads.dsw.gerenciadordejogos.entidade;

import java.time.LocalDate;

import org.springframework.cglib.core.Local;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity 
@Table (name = "tb_jogos")
public class JogoEntity {

    public JogoEntity() {
    }
    

    @Id // faz o banco gerar com auto increment
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false, unique = true, length = 50) //not null e unica
    private String titulo;

    @Column (name = "data_lancamento")
    @Min(value = 1950, message = "O ano deve ser 1950 ou maior")
    private Integer dataLancamento;

    @Column (nullable = false, length = 100)
    private String plataforma;

    @Column (nullable = false)
    private Boolean disponivel;

    @Column (length = 500)
    private String observacoes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Integer dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }



    


}
