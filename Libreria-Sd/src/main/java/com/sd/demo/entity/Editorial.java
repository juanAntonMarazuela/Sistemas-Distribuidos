package com.sd.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Editorial {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long ideditorial;
	
	private String nombre;
	private int numTelefono;
	private String email;
	private String direccionPostal;
	private String codigoIF;
	
	@OneToMany(mappedBy="editorial")
	private List<Libro> libros;
	
	
	public Editorial() {
		
	}
	
	public Editorial(String nombre,int numTelefono, String email
			,String direccionPostal, String codigoIF) {
		this.nombre = nombre;
		this.numTelefono = numTelefono;
		this.email = email;
		this.direccionPostal = direccionPostal;
		this.codigoIF = codigoIF;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(int numTelefono) {
		this.numTelefono = numTelefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccionPostal() {
		return direccionPostal;
	}

	public void setDireccionPostal(String direccionPostal) {
		this.direccionPostal = direccionPostal;
	}

	public String getCodigoIF() {
		return codigoIF;
	}

	public void setCodigoIF(String codigoIF) {
		this.codigoIF = codigoIF;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	
}
