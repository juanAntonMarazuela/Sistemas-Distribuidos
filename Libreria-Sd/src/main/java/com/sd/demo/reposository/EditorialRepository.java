package com.sd.demo.reposository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sd.demo.entity.Editorial;


public interface EditorialRepository extends JpaRepository<Editorial, Long>{
	Editorial findByNombre(String nombre);
	List<Editorial> findByNombreAndCodigoIF(String nombre, String codigoif);
	List<Editorial> findByNombreAndEmail(String nombre, String email);
}
