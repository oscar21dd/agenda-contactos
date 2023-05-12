package com.oscar.app.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oscar.app.interfaceService.IContactoService;
import com.oscar.app.model.Contacto;
import com.oscar.app.repositorio.ContactoRepositorio;

@Service
public class ContactoService implements IContactoService{

	@Autowired
	private ContactoRepositorio contactoRepositorio;
	
	@Override
	public List<Contacto> listar() {
		return (List<Contacto>) contactoRepositorio.findAll();
		
	}
	
	

	@Override
	public int save(Contacto c) {
		int res=0;
		Contacto contacto= contactoRepositorio.save(c);
		if(!contacto.equals(null)) {
			res=1;
		}
		return res;
	}



	@Override
	public Optional<Contacto> listarId(int id) {
		return contactoRepositorio.findById(id);
	}



	@Override
	public void delete(int id) {
		contactoRepositorio.deleteById(id);
		
	}



	

	

	
	
	
	
	
	

}
