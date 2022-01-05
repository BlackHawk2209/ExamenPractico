package com.ibm.academia.apirest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ibm.academia.apirest.entities.Lista;
import com.ibm.academia.apirest.entities.ListaNegra;
import com.ibm.academia.apirest.models.Moneda;
import com.ibm.academia.apirest.models.Pais;
import com.ibm.academia.apirest.repository.ListaNegraRepository;
import com.ibm.academia.apirest.repository.ListaRepository;

@Service
public class ListaServiceImpl implements IListaService {

	@Autowired
	ListaRepository listaRepository;
	
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ListaNegraRepository negraLista;
	
	@Override
	public Optional<Lista> listarPaisInfo(String direccionIP) {
		
		Optional<ListaNegra> busqueda =  negraLista.buscarPorDireccionIp(direccionIP);
		if(busqueda.isPresent()) {
			return  Optional.empty(); 
		}else {
		Pais pais = restTemplate.getForObject("https://api.ip2country.info/ip/{direccionIP}", Pais.class);
		Moneda moneda = restTemplate.getForObject("http://data.fixer.io/api/latest?access_key=852f39f95ebb6d29bd7e201afd96ad83&symbols=USD,AUD,CAD,PLN,MXN&format=1", Moneda.class);
	
		return Optional.of(new Lista(pais,moneda));
	}
	 	
}

	@Override
	public String agregarListaNegra(String direccionIP) {
		ListaNegra listaNegra = null;
		listaNegra.setDireccionIp(direccionIP);
		negraLista.save(listaNegra);
		return "Se guardo la IP en la lista negra";
	}
}
