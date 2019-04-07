package com.fpf.despesas.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fpf.despesas.model.Despesa;
import com.fpf.despesas.repository.DespesaRepository;
import com.fpf.despesas.service.DespesaService;
import com.fpf.despesas.service.exception.DespesaNaoEncontrada;

@RestController
@RequestMapping("/despesas")
@CrossOrigin("*")
public class DespesaResource {
	
	@Autowired
	private DespesaRepository despesaRepository;
	
	@Autowired
	private DespesaService despesaService;
	
	@GetMapping
	public ResponseEntity<List<Despesa>> listarDespesas() {
		return ResponseEntity.ok().body(despesaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Despesa> buscarDespesa(@PathVariable Long id) {
		Optional<Despesa> optional = despesaRepository.findById(id);
		return ResponseEntity.ok().body(optional.get());
	}
	
	@PostMapping
	public ResponseEntity<?> salvarDespesa(@Valid @RequestBody Despesa despesa, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
		}
		
		despesaService.salvar(despesa);
		return ResponseEntity.ok().build();
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deletarDespesa(@PathVariable Long id) {
		despesaService.excluir(id);
	}
	
	@PutMapping
	public ResponseEntity<?> editarDespesa(@Valid @RequestBody Despesa despesa, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
		}
		
		try {
			despesaService.editar(despesa);
		} catch(DespesaNaoEncontrada e) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok().build(); 
	}
}
