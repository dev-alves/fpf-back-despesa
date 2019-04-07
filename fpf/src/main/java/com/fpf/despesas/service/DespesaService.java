package com.fpf.despesas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fpf.despesas.model.Despesa;
import com.fpf.despesas.repository.DespesaRepository;
import com.fpf.despesas.service.event.despesa.DespesaDeletadaEvent;
import com.fpf.despesas.service.event.despesa.DespesaEditadaEvent;
import com.fpf.despesas.service.event.despesa.DespesaSalvaEvent;
import com.fpf.despesas.service.exception.DespesaNaoEncontrada;

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
		despesaRepository.delete(optional.get());
		publisher.publishEvent(new DespesaDeletadaEvent(optional.get().getAnexo()));
	}

	public void editar(Despesa despesa) {
		Optional<Despesa> optional = despesaRepository.findById(despesa.getId());
		if(optional.isPresent()) {
			if(!StringUtils.isEmpty(despesa.getAnexo())) {
				publisher.publishEvent(new DespesaEditadaEvent(despesa.getAnexo(), optional.get().getAnexo()));
			}
		} else {
			throw new DespesaNaoEncontrada("Despesa não encontrada");
		}
		
		despesaRepository.saveAndFlush(despesa);
	}
}
