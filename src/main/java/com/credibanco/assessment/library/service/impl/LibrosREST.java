package com.credibanco.assessment.library.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.library.dto.AutoresDAO;
import com.credibanco.assessment.library.dto.EditorialesDAO;
import com.credibanco.assessment.library.dto.LibrosDAO;
import com.credibanco.assessment.library.model.Autores;
import com.credibanco.assessment.library.model.Editoriales;
import com.credibanco.assessment.library.model.Libros;
import com.credibanco.assessment.library.service.InLibrosService;

@RestController
@RequestMapping("Libros")
public class LibrosREST {

	@Autowired
	private LibrosDAO librosDAO;
	@Autowired
	private AutoresDAO autoresDAO;
	@Autowired
	private EditorialesDAO editorialesDAO;

	// Creo el endpoint POST para registrar el libro
	@PostMapping
	public String createLibro(@RequestBody Libros libro) {

		// Declaración de variables
		String mensaje = "OK";
		String validate = " ";
		String nom_autor = libro.getAutor();
		String nom_editorial = libro.getEditorial();

		// Validación de campo requeridos
		if (libro.getTitulo().isEmpty()) {
			mensaje = "Revise campo Titulo";
			validate = "X";
		}
		if (libro.getAnio() < 0) {
			mensaje = "Revise campo Año";
			validate = "X";
		}
		if (libro.getNum_paginas() < 0) {
			mensaje = "Revise campo Numero Paginas";
			validate = "X";
		}
		if (libro.getAutor().isEmpty()) {
			mensaje = "Revise campo Autor";
			validate = "X";
		}

		// Para seguir validando primero debe tener los campos requeridos
		if (mensaje == "OK") {

			// Validación de autores
			List<Autores> autores = autoresDAO.findAll();
			if (autores.isEmpty()) {
				mensaje = "No se tienen registros de autores";
			}
			for (Autores CurrentAutor : autores) {
				String nombre = CurrentAutor.getNombre();

				if (nombre.equals(nom_autor)) {
					mensaje = "OK";
					break;
				} else {
					mensaje = "El autor no está registrado";
				}
			}
		}

		// Para seguir validando primero debe tener un autor valido
		if (mensaje == "OK") {
			
			// Validación de editorial
			List<Editoriales> editoriales = editorialesDAO.findAll();
			if (editoriales.isEmpty()) {
				mensaje = "No se tienen registros de editoriales";
			}
			for (Editoriales CurrentEditorial : editoriales) {
				String nombre_e = CurrentEditorial.getNombre();

				if (nombre_e.equals(nom_editorial)) {
					mensaje = "OK";
					break;
				} else {
					mensaje = "La editorial no está registrada";
				}
			}
		}

		// Si no se tiene ningun error se registra el libro
		if (mensaje == "OK") {
			librosDAO.save(libro);
		}

		return mensaje;
	}
	
	// Servicio para consulta por ID
	@RequestMapping(value="{p_clave}")
	public ResponseEntity<Libros> getLibro(@PathVariable("p_clave") int p_clave){
		
		// Si encuentra el ID muestro solamente ese libro
		Optional<Libros> optionalLibro = librosDAO.findById(p_clave);
		
		if(optionalLibro.isPresent()) {
			return ResponseEntity.ok(optionalLibro.get());
		}else {		
			return ResponseEntity.noContent().build();
		}
	}
}
