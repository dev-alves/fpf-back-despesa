package com.fpf.despesas.service.event.despesa;

import org.springframework.util.StringUtils;

public class DespesaDeletadaEvent {
	
	private String local;
	
	public DespesaDeletadaEvent(String local) {
		this.local = local;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	
	public boolean anexoDespesa() {
		return !StringUtils.isEmpty(local);
	}
	
}
