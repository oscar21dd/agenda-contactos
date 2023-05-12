package com.oscar.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oscar.app.model.Contacto;

@Repository
public interface ContactoRepositorio extends JpaRepository<Contacto,Integer> {

}
