package com.ibm.academia.apirest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.entities.Lista;
import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.services.IListaService;

@RestController
@RequestMapping("/lista")
public class ListaControllers {

	@Autowired
	IListaService listaService;
	
	
	/**
	 * Endpoint para buscar los paises por su IP y cambio de moneda
	 * @param direccioIP
	 * @return el objeto de lista que tiene pais y moneda
	 * @author BPG
	 */
	@GetMapping("/direccionIP/{direccionIP}")
	public ResponseEntity<?> listarPaisInfo(@PathVariable String direccioIP){
		
		Optional<Lista> infoPaises = listaService.listarPaisInfo(direccioIP);

			if(infoPaises.isEmpty())
				throw new NotFoundException("Esta en la lista negra o no se encontro la IP");
		
			return new ResponseEntity<Lista>(infoPaises.get(), HttpStatus.OK);
	}
	
	/**
	 * Endpoint para agregar una IP a la lista negra
	 * @param direccionIP
	 * @return un string si se agrego o no a la lista negra
	 * @author BPG
	 */
	@GetMapping("/listaNegra/direccionIP/{direccionIP}")
	public String agregarListaNegra(@PathVariable String direccionIP){
		
		String listaNegra = listaService.agregarListaNegra(direccionIP);
		if(listaNegra.isBlank())
			throw new NotFoundException("No se agrego a la listanegra");
		
		return listaNegra;
		
	}
}
