package com.credibanco.assessment.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

	@PostMapping
	public String createLibro(@RequestBody Libros libro) {

		String mensaje = "OK";
		String validate = " ";
		String nom_autor = libro.getAutor();
		String nom_editorial = libro.getEditorial();

		if (libro.getTitulo().isEmpty()) {
			validate = "X";
		}
		if (libro.getAnio() < 0) {
			validate = "X";
		}
		if (libro.getNum_paginas() < 0) {
			validate = "X";
		}
		if (libro.getAutor().isEmpty()) {
			validate = "X";
		}

		if (validate == "X") {
			mensaje = "Verifique los campos obligatorios";
		}

		if (mensaje == "OK") {

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

		if (mensaje == "OK") {
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

		if (mensaje == "OK") {
			librosDAO.save(libro);
		}

		return mensaje;
	}

}
