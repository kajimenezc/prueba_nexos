package com.credibanco.assessment.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.library.interfaces.InLibrosService;
import com.credibanco.assessment.library.model.Libros;


@Controller
@RequestMapping
public class ControllerLibros {

	@Autowired
	private InLibrosService service;
	
	@GetMapping("/Listar")
	public String listar(Model model) {
		List<Libros>libros=service.listar();
		model.addAttribute("libros", libros);
		return "index";
	}
	
	/*@RestController
	@RequestMapping("/CreateLibro")
	public class CreateLibro {
			@GetMapping
			public ResponseEntity<Long> getProduct(){
				Libros libros = new Libros();
				libros.setId(1L);

				return ResponseEntity.ok(libros.getId());
			}
	}*/
	
	
}
