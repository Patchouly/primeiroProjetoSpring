package com.cursospring.helloword.domain.enums;

public enum EstadoPagamento {
	
	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private int id;
	private String desc;
	
	private EstadoPagamento(int id, String desc) {
		this.id = id;
		this.desc = desc;
	}

	public int getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}
	
	public static EstadoPagamento toEnum(Integer id) {
		
		if (id == null) {
			return null;
		}
		
		for  (EstadoPagamento tipo : EstadoPagamento.values()) {
			if (id.equals(tipo.getId())) {
				return tipo;
			}
		}
		
		throw new IllegalArgumentException("Id invalido: "+ id);
	}
}
