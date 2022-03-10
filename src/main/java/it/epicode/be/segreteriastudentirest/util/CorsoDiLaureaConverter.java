package it.epicode.be.segreteriastudentirest.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import it.epicode.be.segreteriastudentirest.model.CorsoDiLaurea;
import it.epicode.be.segreteriastudentirest.service.CorsoDiLaureaService;


@Component
public class CorsoDiLaureaConverter implements Converter<Long, CorsoDiLaurea>{
	
	@Autowired
	CorsoDiLaureaService corsoDiLaureaService;

	@Override
	public CorsoDiLaurea convert(Long id) {
		
		return corsoDiLaureaService.findById(id).get();
	}

}
