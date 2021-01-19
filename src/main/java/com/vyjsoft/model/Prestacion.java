package com.vyjsoft.model;

import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "PRESTACIONES")
public class Prestacion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long idPrestacion;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "capitulo")
	private int capitulo;
	
	@Column(name = "sub_capitulo")
	private int subCapitulo;
	
	 
	
	@OneToMany(mappedBy = "prestacion")
	private Set<Nomenclador> nomenclador;



	public Long getIdPrestacion() {
		return idPrestacion;
	}



	public void setIdPrestacion(Long idPrestacion) {
		this.idPrestacion = idPrestacion;
	}



	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public int getCapitulo() {
		return capitulo;
	}



	public void setCapitulo(int capitulo) {
		this.capitulo = capitulo;
	}



	public int getSubCapitulo() {
		return subCapitulo;
	}



	public void setSubCapitulo(int subCapitulo) {
		this.subCapitulo = subCapitulo;
	}



	public Set<Nomenclador> getNomenclador() {
		return nomenclador;
	}



	public void setNomenclador(Set<Nomenclador> nomenclador) {
		this.nomenclador = nomenclador;
	}



	
}
