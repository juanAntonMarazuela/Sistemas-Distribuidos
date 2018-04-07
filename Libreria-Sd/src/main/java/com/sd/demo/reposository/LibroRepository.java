package com.sd.demo.reposository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sd.demo.entity.Editorial;
import com.sd.demo.entity.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long>{
	
	Libro findByTitulo(String titulo);
	Libro findByAutor(String autor);
	List<Libro> findByTituloAndAutor(String titulo, String autor);
	List<Libro> findByEditorial(Editorial editorial);
	
	List<Libro> findAllByOrderByAutorAsc();
	List<Libro> findAllByOrderByEditorialAsc();
	List<Libro> findAllByOrderByTituloAsc();

}
