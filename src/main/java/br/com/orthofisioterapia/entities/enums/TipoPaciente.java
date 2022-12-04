package br.com.orthofisioterapia.entities.enums;

public enum TipoPaciente {
	
	FISIOTERAPIA(1, "Fisioterapia"), PILATES(2, "Pilates");
	
	private Integer cod;
	private String description;
	
	private TipoPaciente(Integer cod, String description) {
		this.cod = cod;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public static TipoPaciente toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(TipoPaciente x : TipoPaciente.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Invalid ID: "+cod);
	}
}
