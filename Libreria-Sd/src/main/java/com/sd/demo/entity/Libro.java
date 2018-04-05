package com.sd.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Libro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String autor;
	private String titulo;
	private int ano;
	private int numPaginas;
	private String isbn;
	private double precio;
	private String categoria;
	
	@ManyToOne
	@JoinColumn(name = "ideditorial")
	private Editorial editorial;
	

	public Libro() {
		
	}
	
	public Libro(String autor,String titulo, int añoPublicacion
			,int numPaginas, String isbn, double precio, String categoria, Editorial editorial) {
		this.autor = autor;
		this.titulo = titulo;
		this.editorial = editorial;
		this.ano = añoPublicacion;
		this.numPaginas = numPaginas;
		this.isbn = isbn;
		this.precio = precio;
		this.categoria = categoria;
		
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Editorial getEditorial() {
		return editorial;
	}
	
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int añoPublicacion) {
		this.ano = añoPublicacion;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public Long getId() {
		return this.id;
	}
	
}
