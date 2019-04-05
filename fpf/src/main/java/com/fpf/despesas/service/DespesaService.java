package com.fpf.despesas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.fpf.despesas.model.Despesa;
import com.fpf.despesas.repository.DespesaRepository;
import com.fpf.despesas.service.event.despesa.DespesaDeletadaEvent;
import com.fpf.despesas.service.event.despesa.DespesaSalvaEvent;

@Service
public class DespesaService {
	
	@Autowired
	private DespesaRepository despesaRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	public void salvar(Despesa despesa) {
		despesaRepository.save(despesa);
		publisher.publishEvent(new DespesaSalvaEvent(despesa));
	}

	public void excluir(Long id) {
		Optional<Despesa> optional = despesaRepository.findById(id);
		publisher.publishEvent(new DespesaDeletadaEvent(optional.get().getAnexo()));
	}

}
