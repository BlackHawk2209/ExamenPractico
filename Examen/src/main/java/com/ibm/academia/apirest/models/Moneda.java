package com.ibm.academia.apirest.models;

import lombok.Data;

@Data
public class Moneda {

	private boolean success;
	private Integer timestamp;
	private String base;
	private String date;
	
	private Rango rates;
	
	
}
