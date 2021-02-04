package com.credibanco.assessment.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.library.model.Libros;

@Service
public class LibrosService implements InLibrosService {

	@Autowired
	private InLibros data;
	
	@Override
	public List<Libros> listar() {
		return (List<Libros>) data.findAll();
	}

	@Override
	public Optional<Libros> listarID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Libros p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResponseEntity<Libros> createLibro() {
		// TODO Auto-generated method stub
		return null;
	}

}
