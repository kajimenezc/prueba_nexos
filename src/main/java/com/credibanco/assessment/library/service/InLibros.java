package com.credibanco.assessment.library.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.credibanco.assessment.library.model.Libros;

@Repository
public interface InLibros extends CrudRepository<Libros, Integer> {
}
