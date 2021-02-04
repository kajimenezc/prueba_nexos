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
		
		String mensaje = "Proceso realizado con exito";
		String validate = " ";
		
		if(editoriales.getNombre().isEmpty()) { validate = "X"; }
		if(editoriales.getDireccion().isEmpty()) { validate = "X"; }
		if(editoriales.getTelefono() <= 0 ) { validate = "X"; }
		if(editoriales.getNombre().isEmpty()) { validate = "X"; }
		
		if( validate == "X" ) {
			mensaje = "Verifique los campos obligatorios";
		}else {
			editorialesDAO.save(editoriales);
		}
		
		return mensaje;
	}
	
}
