package br.senac.tads.dsw.gerenciadordejogos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

//classe criada para representar os dados editaveis (titulo por exemplo nao é editavel)

public class JogoAlteracaoDto {

	@NotNull // de acordo com a etapa 3, nao necessariamente esass anotacoes fazem sentido na alteracao
	@Min(value = 1950, message = "O ano deve ser 1950 ou maior")
	private Integer dataLancamento;

	@NotBlank
	@Size(max = 100)
	private String plataforma;

	@NotNull
	private boolean disponivel;

	@Size(max = 500)
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
