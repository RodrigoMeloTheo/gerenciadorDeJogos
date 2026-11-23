package br.senac.tads.dsw.gerenciadordejogos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class JogoAlteracaoDto {

	@NotNull
	@Min(value = 1950, message = "O ano deve ser 1950 ou maior")
	private Integer dataLancamento;

	@NotBlank
	@Size(max = 100)
	private String plataforma;

	@NotNull
	private boolean disponivel;

	@Size(max = 50)
	private String observacoes;

	public JogoAlteracaoDto() {
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

	public boolean getDisponivel() {
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
