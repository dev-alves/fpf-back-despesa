package com.fpf.despesas.service.event.despesa;

import org.springframework.util.StringUtils;

import com.fpf.despesas.model.Despesa;

public class DespesaSalvaEvent {

	private Despesa despesa;
	
	public DespesaSalvaEvent(Despesa despesa) {
		this.despesa = despesa;
	}

	public Despesa getDespesa() {
		return despesa;
	}

	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}
	
	public boolean temAnexo() {
		return !StringUtils.isEmpty(despesa.getAnexo());
	}
	
}
