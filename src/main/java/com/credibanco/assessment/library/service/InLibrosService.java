package com.credibanco.assessment.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.credibanco.assessment.library.model.Libros;

public interface InLibrosService {

	public List<Libros>listar();
	public Optional<Libros>listarID(int id);
	public int save(Libros p);
	public void delete(int id);
	public ResponseEntity<Libros>createLibro();
	
}
