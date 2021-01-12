package com.vyjsoft.resolver;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.vyjsoft.model.Nomenclador;
import com.vyjsoft.model.Prestacion;
import com.vyjsoft.repository.NomencladorRepository;


@Component
public class PrestacionResolver implements GraphQLResolver<Prestacion> {
	
	@Autowired
	private NomencladorRepository repository;

	
	public PrestacionResolver(NomencladorRepository repository) {
		
		this.repository = repository;
	}
	
	public Optional<Nomenclador> getNomenclador(Prestacion prestacion) {
		return repository.findByCodigo(((Nomenclador) prestacion.getNomenclador()).getCodigo());
	}

}
