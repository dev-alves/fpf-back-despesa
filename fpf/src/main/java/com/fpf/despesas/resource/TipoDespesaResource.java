package com.fpf.despesas.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpf.despesas.model.TipoDespesa;
import com.fpf.despesas.repository.TipoDespesaRepository;

@RestController
@RequestMapping("tipos-despesa")
@CrossOrigin
public class TipoDespesaResource {
	
	@Autowired
	private TipoDespesaRepository tipoDespesaRepository;
	
	@GetMapping
	public ResponseEntity<List<TipoDespesa>> listarDespesas() {
		return ResponseEntity.ok().body(tipoDespesaRepository.findAll());
	}
	
}
