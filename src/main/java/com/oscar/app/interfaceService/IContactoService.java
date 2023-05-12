package com.oscar.app.interfaceService;

import java.util.List;
import java.util.Optional;

import com.oscar.app.model.Contacto;

public interface IContactoService {
	
	public List<Contacto> listar();
	public int save(Contacto c);
	public Optional<Contacto>listarId(int id);
	public void delete(int id);

}
