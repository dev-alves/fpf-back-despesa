package com.fpf.despesas.service.exception;

public class DespesaNaoEncontrada extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DespesaNaoEncontrada(String msg) {
		super(msg);
	}

}
