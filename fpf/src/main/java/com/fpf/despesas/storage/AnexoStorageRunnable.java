package com.fpf.despesas.storage;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import com.fpf.despesas.dto.AnexoDTO;

public class AnexoStorageRunnable implements Runnable {

	private MultipartFile[] anexo;
	private DeferredResult<AnexoDTO> deferredResult;
	private AnexoStorage anexoStorage;
	

	public AnexoStorageRunnable(MultipartFile[] anexo, DeferredResult<AnexoDTO> deferredResult,
			AnexoStorage anexoStorage) {
		this.anexo = anexo;
		this.deferredResult = deferredResult;
		this.anexoStorage = anexoStorage;
	}


	@Override
	public void run() {
		String nome = this.anexoStorage.salvarTemporariamente(anexo);
		String contentType = this.anexo[0].getContentType();
		
		deferredResult.setResult(new AnexoDTO(nome, contentType));
	}

}
