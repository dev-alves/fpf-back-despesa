package com.fpf.despesas.storage;

import org.springframework.web.multipart.MultipartFile;

public interface AnexoStorage {

	String salvarTemporariamente(MultipartFile[] file);
	byte[] recuperarAnexoTemporario(String nome);
	void moverParaPastaPrincipal(String anexo);
	void removerAnexoTemporario(String nome);
	void removerAnexoPrincipal(String nome);

	byte[] recuperar(String nome);
	
}
