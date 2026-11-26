package br.senac.tads.dsw.gerenciadordejogos;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;


//JogoDto é a classe do objeto JOGO, é uma dto pois os dados vao ser transferidos (data trasfer Object). Ela quem define as validacoes de cada atributo 


public class JogoDto {

    private Integer id;

    @NotBlank (message = "Insira o Titulo do jogo") // Não nulo + não vazio + sem espaços em branco
    @Size (max = 100)
    private String titulo;

    @NotNull //Não nulo (funciona para qualquer tipo, não só String)
    @Min(value = 1950, message = "O ano deve ser 1950 ou maior")
    private Integer dataLancamento;

    @NotBlank
    @Size (max = 100)
    private String plataforma;

    @NotNull  // usei ia aqui, pra validar boolean o claude disse que eu preciso usar um Boolean com b maiusculo para dar certyo
    private Boolean disponivel;

    @Size (max = 500)
    private String observacoes;


    public JogoDto() {
    }




    public JogoDto(Integer id, String titulo, Integer dataLancamento, String plataforma, Boolean disponivel,
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
