package com.ibm.academia.apirest.entities;

import com.ibm.academia.apirest.models.Moneda;
import com.ibm.academia.apirest.models.Pais;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Lista {
	
	private Pais pais;
	private Moneda moneda;
		
}
