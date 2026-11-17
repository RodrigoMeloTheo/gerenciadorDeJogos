package br.senac.tads.dsw.gerenciadordejogos;

import java.time.LocalDate;
import java.util.List;

public class Jogo {

    private Integer id;
    private String titulo;
    private LocalDate dataLancamento;
    private String plataforma;
    private boolean disponivel;
    private String observacoes;


    public Jogo() {
    }

    


    public Jogo(Integer id, String titulo, LocalDate dataLancamento, String plataforma, boolean disponivel,
            String observacoes) {
        this.id = id;
        this.titulo = titulo;
        this.dataLancamento = dataLancamento;
        this.plataforma = plataforma;
        this.disponivel = disponivel;
        this.observacoes = observacoes;
    }




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


    public LocalDate getDataLancamento() {
        return dataLancamento;
    }


    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }


    public String getPlataforma() {
        return plataforma;
    }


    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }


    public boolean isDisponivel() {
        return disponivel;
    }


    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }


    public String getObservacoes() {
        return observacoes;
    }


    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    

    

}
