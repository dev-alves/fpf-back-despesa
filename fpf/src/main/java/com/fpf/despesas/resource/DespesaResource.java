package com.fpf.despesas.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fpf.despesas.model.Despesa;
import com.fpf.despesas.repository.DespesaRepository;
import com.fpf.despesas.service.DespesaService;

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
	
	@PostMapping
	public ResponseEntity<?> salvarDespesa(@Valid @RequestBody Despesa despesa, BindingResult bindingResult) {
		
		System.out.println("Despesa " + despesa.getValorDespesa());
		
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
		}
		
		despesaService.salvar(despesa);
		return ResponseEntity.ok().build();
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping
	public void deletarDespesa(@RequestParam Long id) {
		despesaService.excluir(id);
	}
}
