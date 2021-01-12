package com.vyjsoft.resolver;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.vyjsoft.model.Nomenclador;
import com.vyjsoft.model.Prestacion;
import com.vyjsoft.repository.NomencladorRepository;
import com.vyjsoft.repository.PrestacionRepository;

import javassist.NotFoundException;

public class MutationResolver implements GraphQLMutationResolver {
	
	private NomencladorRepository nomencladorRepository;
	private PrestacionRepository prestacionRepository;
	
	@Autowired
	public MutationResolver(NomencladorRepository nomencladorRepository, PrestacionRepository prestacionRepository) {
		
		this.nomencladorRepository = nomencladorRepository;
		this.prestacionRepository = prestacionRepository;
	}
	
	public Nomenclador crearNomenclador(String codigo, String descripcion) {
		
		Nomenclador nom = new Nomenclador();
		nom.setCodigo(codigo);
		nom.setDescripcion(descripcion);
		nomencladorRepository.save(nom);
		return nom;
	}

	public Prestacion crearPrestacion(String codigo, String descripcion, Set<Nomenclador> nomenclador, int capitulo, int subcapitulo) {
		Prestacion presta = new Prestacion();
		presta.setCodigo(codigo);
		presta.setDescripcion(descripcion);
		presta.setNomenclador( nomenclador);
		presta.setCapitulo(capitulo);
		presta.setSubCapitulo(subcapitulo);
		
		prestacionRepository.save(presta);
		return presta;
	}
	
	
	
	public Prestacion updatePrestacion(String codigo, String descripcion, Set<Nomenclador> nomenclador, Integer capitulo, Integer subcapitulo) throws NotFoundException  {
		{
			
			Optional<Prestacion> opPrestacion = prestacionRepository.findByCodigo(codigo);
			if(opPrestacion.isPresent()) {
				Prestacion presta = opPrestacion.get();
				if(descripcion != null)
					presta.setDescripcion(descripcion);
				if(nomenclador != null)
					presta.setNomenclador(nomenclador);
				if(capitulo != null)
					presta.setCapitulo(capitulo);
				if(subcapitulo != null)
					presta.setSubCapitulo(subcapitulo);
				prestacionRepository.save(presta);
				
				return presta;
			}
			
			throw new NotFoundException("No existe la prestacion");
		}
	} 
	
	public Nomenclador updateNomenclador(String codigo, String desc) throws NotFoundException{
		Optional<Nomenclador> optNomenclador = nomencladorRepository.findByCodigo(codigo);
		
		if(optNomenclador.isPresent()) {
			Nomenclador nom = optNomenclador.get();
			if(desc != null)
				nom.setDescripcion(desc);
			nomencladorRepository.save(nom);
			return nom;
		}
		throw new NotFoundException("No existe el nomenclador");
	}
	
	public boolean deletePrestacion(String codigo) {
		prestacionRepository.deleteByCodigo(codigo);
		return true;
	}
	
	public boolean deleteNomeclador(String codigo) {
		nomencladorRepository.deleteByCodigo(codigo);
		return true;
	}
	
}
