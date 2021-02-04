package com.credibanco.assessment.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.credibanco.assessment.library.dto.EditorialesDAO;
import com.credibanco.assessment.library.model.Editoriales;

@RestController
@RequestMapping("Editoriales")
public class EditorialesREST {

    @Autowired
	private EditorialesDAO editorialesDAO;

	@PostMapping
	public String createEditorial(@RequestBody Editoriales editoriales) {
	
		// Declaración de variables
		String mensaje = "Proceso realizado con exito";
		String validate = " ";
		
		// Validacións para la creación
		if(editoriales.getNombre().isEmpty()) { validate = "X"; mensaje = "Verifique campo nombre"; }
		if(editoriales.getDireccion().isEmpty()) { validate = "X"; mensaje = "Verifique campo dirección"; }
		if(editoriales.getTelefono() < 0 ) { validate = "X"; mensaje = "Verifique campo telefono"; }
		if(editoriales.getMax_libros() >= 9999) { validate = "X"; mensaje = "Verifique maximo de libros"; }
		
		if( validate != "X" ) {
			editorialesDAO.save(editoriales);
		}
		
		return mensaje;
	}
	
}
