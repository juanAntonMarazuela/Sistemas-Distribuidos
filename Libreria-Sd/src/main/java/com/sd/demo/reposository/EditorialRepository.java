package com.sd.demo.reposository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sd.demo.entity.Editorial;
import com.sd.demo.entity.Libro;

public interface EditorialRepository extends JpaRepository<Editorial, Long>{
	Editorial findByNombre(String nombre);
	
}
