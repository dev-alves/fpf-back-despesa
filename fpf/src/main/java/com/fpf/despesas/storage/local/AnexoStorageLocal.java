package com.fpf.despesas.storage.local;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.fpf.despesas.storage.AnexoStorage;

public class AnexoStorageLocal implements AnexoStorage {

	private Path local;
	private Path localTemporario;
	
	public AnexoStorageLocal() {
		this(FileSystems.getDefault().getPath(System.getenv("HOME"), ".anexos"));
	}
	
	public AnexoStorageLocal(Path local) {
		this.local = local;
		criarPastas();
	}
	
	@Override
	public String salvarTemporariamente(MultipartFile[] file) {
		String nome = null;
		if(file != null && file.length > 0) {
			MultipartFile multipartFile = file[0];
			nome = chaveUnica(multipartFile.getOriginalFilename());
			try {
				multipartFile.transferTo(new File(this.localTemporario.toAbsolutePath().toString() 
						+ FileSystems.getDefault().getSeparator() + nome));
			} catch(IOException e) {
				throw new RuntimeException("Erro ao salvar o anexo na pasta temporária: " + e.getMessage());
			}
		}
		
		return nome;
	}

	@Override
	public byte[] recuperarAnexoTemporario(String nome) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public void removerAnexoPrincipal(String nome) {
		try {
			Files.deleteIfExists(this.local.resolve(nome));
		} catch (IOException e) {
			throw new RuntimeException("Erro ao deletar anexo " + e.getMessage());
		}
	}


	@Override
	public void moverParaPastaPrincipal(String anexo) {
		try {
			Files.move(this.localTemporario.resolve(anexo), this.local.resolve(anexo));
		} catch (IOException e) {
			throw new RuntimeException("Erro ao mover o anexo para a pasta temporária: " + e.getMessage());
		}
	}

	@Override
	public void removerAnexoTemporario(String nome) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public byte[] recuperar(String nome) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String chaveUnica(String originalFilename) {
		return UUID.randomUUID().toString() + "_" + originalFilename;
	}
	
	private void criarPastas() {
		try {
			Files.createDirectories(this.local);
			this.localTemporario = FileSystems.getDefault().getPath(this.local.toString(), "temp");
			
			Files.createDirectories(this.localTemporario);
			
		} catch(IOException e) {
			throw new RuntimeException("Erro ao criar as pastas para salvar os aneox " + e.getMessage());
		}
	}
}
