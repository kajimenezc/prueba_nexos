package com.credibanco.assessment.library.dto;

import org.springframework.data.jpa.repository.JpaRepository;

import com.credibanco.assessment.library.model.Libros;

public interface LibrosDAO extends JpaRepository<Libros, Integer> {

}
