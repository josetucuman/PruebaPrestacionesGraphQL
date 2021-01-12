package com.vyjsoft.model;

import javax.persistence.*;


@Entity
@Table(name = "DESARROLLO.PRE001")
public class Nomenclador {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "TNO_COD")
	private String codigo;
	
	@Column(name = "TNO_DES")
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="prestacion_codigo")
	private Prestacion prestacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Prestacion getPrestacion() {
		return prestacion;
	}

	public void setPrestacion(Prestacion prestacion) {
		this.prestacion = prestacion;
	}

}
