package com.sd.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long>{
	
	Libro findByTitulo(String titulo);
	Libro findByAutor(String autor);
	List<Libro> findByTituloAndAutor(String titulo, String autor);


}
