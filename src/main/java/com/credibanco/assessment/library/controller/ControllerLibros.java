package com.credibanco.assessment.library.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.library.dto.LibrosDAO;
import com.credibanco.assessment.library.model.Libros;
import com.credibanco.assessment.library.service.InLibrosService;


@Controller       
@RequestMapping
public class ControllerLibros {

	@Autowired
	private InLibrosService librosService;
	
	@GetMapping("/Listar")
	public String listar(Model model) {
		List<Libros>libros=librosService.listar();
		model.addAttribute("libros", libros);
		return "index";
	}
	
}
