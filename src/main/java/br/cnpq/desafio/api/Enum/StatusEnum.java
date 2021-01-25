package br.cnpq.desafio.api.Enum;

public enum StatusEnum {
	NEW,
	ASSIGNED,
	RESOLVED,
	APROVADO,
	REPROVADO,
	CLOSE;
	
	public static StatusEnum getStatus(String status) {
		switch (status) {
		case "NEW" : return NEW;
		case "ASSIGNED" : return ASSIGNED;
		case "RESOLVED" : return RESOLVED;
		case "APROVADO" : return APROVADO;
		case "REPROVADO" : return REPROVADO;
		case "CLOSE" : return CLOSE;
		default: return NEW;
		
		}
	}
}
