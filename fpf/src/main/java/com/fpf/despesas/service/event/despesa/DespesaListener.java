package com.fpf.despesas.service.event.despesa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.fpf.despesas.storage.AnexoStorage;

@Component
public class DespesaListener {
	
	@Autowired
	private AnexoStorage anexoStorage;
	
	@EventListener(condition = "#evento.temAnexo()")
	public void despesaSalva(DespesaSalvaEvent evento) {
		anexoStorage.moverParaPastaPrincipal(evento.getDespesa().getAnexo());
	}
	
	@EventListener(condition = "#evento.anexoEditado()")
	public void despesaEditada(DespesaEditadaEvent evento) {
		anexoStorage.removerAnexoPrincipal(evento.getAnexoAntigo());
		anexoStorage.moverParaPastaPrincipal(evento.getNovoAnexo());
	}
	
	@EventListener(condition = "#evento.anexoDespesa()")
	public void despesaDeletada(DespesaDeletadaEvent evento) {
		anexoStorage.removerAnexoPrincipal(evento.getLocal());
	}
}
