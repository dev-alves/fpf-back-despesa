package com.fpf.despesas.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "despesa")
public class Despesa implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Column(name = "DESCRICAO")
	private String descricao;
	
	@NotNull(message = "O valor da despesa é obrigatório")
	@Column(name = "VALOR")
	private BigDecimal valorDespesa;
	
	
	@NotNull(message = "A data da despesa é obrigatório")
	@Column(name = "DATA_DESPESA")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataDespesa;
	
	@Column(name = "ANEXO")
	private String anexo;
	
	@OneToOne
	@JoinColumn(name = "TIPO_DESPESA")
	@NotNull(message = "O tipo da despesa é obrigatório")
	private TipoDespesa tipoDespesa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public BigDecimal getValorDespesa() {
		return valorDespesa;
	}

	public void setValorDespesa(BigDecimal valorDespesa) {
		this.valorDespesa = valorDespesa;
	}


	public LocalDate getDataDespesa() {
		return dataDespesa;
	}

	public void setDataDespesa(LocalDate dataDespesa) {
		this.dataDespesa = dataDespesa;
	}

	public String getAnexo() {
		return anexo;
	}

	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}

	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}
}
