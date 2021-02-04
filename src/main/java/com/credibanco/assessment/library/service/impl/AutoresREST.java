package com.credibanco.assessment.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.credibanco.assessment.library.dto.AutoresDAO;
import com.credibanco.assessment.library.model.Autores;

@RestController
@RequestMapping("Autores")
public class AutoresREST {

    @Autowired
	private AutoresDAO autoresDAO;

	@PostMapping
	public String createEditorial(@RequestBody Autores autores) {
		
		// Declaración de variables
		String mensaje = "Proceso realizado con exito";
		String validate = " ";
		
		// Validacións para la creación
		if(autores.getNombre().isEmpty()) { validate = "X"; }
		
		if( validate == "X" ) {
			mensaje = "Verifique el campo nombre";
		}else {
			autoresDAO.save(autores);
		}
		
		return mensaje;
	}
	
}
