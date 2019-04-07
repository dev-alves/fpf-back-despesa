package com.fpf.despesas.service.event.despesa;

import org.springframework.util.StringUtils;

public class DespesaEditadaEvent  {
	
	private String novoAnexo;
	private String anexoAntigo;

	public DespesaEditadaEvent(String novoAnexo, String anexoAntigo) {
		this.novoAnexo = novoAnexo;
		this.anexoAntigo = anexoAntigo;
	}

	public String getNovoAnexo() {
		return novoAnexo;
	}

	public void setNovoAnexo(String novoAnexo) {
		this.novoAnexo = novoAnexo;
	}

	public String getAnexoAntigo() {
		return anexoAntigo;
	}

	public void setAnexoAntigo(String anexoAntigo) {
		this.anexoAntigo = anexoAntigo;
	}
	
	public boolean anexoEditado() {
		return !StringUtils.isEmpty(novoAnexo);
	}
	
}
