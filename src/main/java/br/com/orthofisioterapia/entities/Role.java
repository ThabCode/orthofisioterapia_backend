package br.com.orthofisioterapia.entities;

public enum Role {
			
		ADMIN(1, "ROLE_ADMIN"),
		PACIENTE(2,"ROLE_PACIENTE");
		
		private Integer cod;
		private String descricao;
		
		private Role(Integer cod, String descricao) {
			this.cod = cod;
			this.descricao = descricao;
		}

		public Integer getCod() {
			return cod;
		}

		public String getDescricao() {
			return descricao;
		}
		
		public static Role toEnum(Integer cod) {
			if(cod == null) {
				return null;
			}
			for (Role x : Role.values()) {
					if(cod.equals(x.getCod())) {
						return x;
					}
			}
			throw new IllegalArgumentException("Id invalido: "+ cod);
		}
	}



