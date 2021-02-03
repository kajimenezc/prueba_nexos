package com.credibanco.assessment.library.interfaces;

import java.util.List;
import java.util.Optional;

import com.credibanco.assessment.library.model.Libros;

public interface InLibrosService {

	public List<Libros>listar();
	public Optional<Libros>listarID(int id);
	public int save(Libros p);
	public void delete(int id);
	
}
