package com.fpf.despesas.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import com.fpf.despesas.dto.AnexoDTO;
import com.fpf.despesas.storage.AnexoStorage;
import com.fpf.despesas.storage.AnexoStorageRunnable;

@RestController
@RequestMapping("/anexos")
@CrossOrigin
public class AnexoResource {
	
	@Autowired
	private AnexoStorage anexoStorage;
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping
	public DeferredResult<AnexoDTO> upload(@RequestParam MultipartFile[] anexo) {
		DeferredResult<AnexoDTO> deferredResult = new DeferredResult<>();
		Thread thread = new Thread(new AnexoStorageRunnable(anexo, deferredResult, anexoStorage));
		
		thread.start();
		return deferredResult;
	}
	
	
}
