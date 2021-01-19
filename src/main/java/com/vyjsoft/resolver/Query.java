package com.vyjsoft.resolver;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.vyjsoft.model.Nomenclador;
import com.vyjsoft.model.Prestacion;
import com.vyjsoft.repository.NomencladorRepository;
import com.vyjsoft.repository.PrestacionRepository;

public class Query implements GraphQLQueryResolver {
	
	
	private NomencladorRepository nomencladorRepository;
	private PrestacionRepository prestacionRepository;
	
	@Autowired
	public Query(NomencladorRepository nomencladorRepository, PrestacionRepository prestacionRepository) {
		super();
		this.nomencladorRepository = nomencladorRepository;
		this.prestacionRepository = prestacionRepository;
	}
	
	
	//Traer todas las prestaciones
	/**
	 * 
	 * @return Lista de Prestaciones
	 */
	public Iterable<Prestacion> traerPrestaciones(){
		return prestacionRepository.findAll();
	}
	
	public Prestacion traerPrestacion(Long id) {
		return prestacionRepository.findById(id).orElse(null);
	}
	
	/**
	 * 
	 * @return
	 */
	public Iterable<Nomenclador> traerNomencladores(){
		
		return nomencladorRepository.findAll();
	}
	
	public Long countPrestacion() {
		return prestacionRepository.count();
	}
	
	public Long countNomenclador() {
		return nomencladorRepository.count();
	}
}
