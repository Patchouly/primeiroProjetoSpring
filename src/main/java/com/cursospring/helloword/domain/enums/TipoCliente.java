package com.cursospring.helloword.domain.enums;

public enum TipoCliente {
	
	PESSOAFISICA(1, "Pessoa Fisíca"),
	PESSOAJURIDICA(2, "pessoa jurídica");
	
	private int id;
	private String desc;
	
	private TipoCliente(int id, String desc) {
		this.id = id;
		this.desc = desc;
	}

	public int getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}
	
	public static TipoCliente toEnum(Integer id) {
		
		if (id == null) {
			return null;
		}
		
		for  (TipoCliente tipo : TipoCliente.values()) {
			if (id.equals(tipo.getId())) {
				return tipo;
			}
		}
		
		throw new IllegalArgumentException("Id invalido: "+ id);
	}
}
