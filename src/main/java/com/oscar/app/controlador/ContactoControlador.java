package com.oscar.app.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oscar.app.model.Contacto;
import com.oscar.app.service.ContactoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping
public class ContactoControlador {
	@Autowired
	private ContactoService contactoService;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Contacto> contactos= contactoService.listar();
		model.addAttribute("contactos", contactos);
		return "index";	
	}
	
	@GetMapping("/new")
	public String mostrarFormularioDeRegistrarContacto(Model modelo) {
		Contacto contacto= new Contacto();
		modelo.addAttribute("contacto", contacto);
		return "nuevo_contacto";
	}
	
	@PostMapping("/save")
	public String save(@Valid Contacto c,Model model) {
		contactoService.save(c);
		return "redirect:/listar";
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable int id,Model model) {
		ModelAndView modelo = new ModelAndView("editar_contacto");
		Optional contacto = contactoService.listarId(id);
		modelo.addObject("contacto", contacto);
		return modelo;
	}
	
	@GetMapping("/eliminar/{id}")
	public String delete(Model model,@PathVariable int id) {
		contactoService.delete(id);
		return "redirect:/listar";
	}
	
	

}
