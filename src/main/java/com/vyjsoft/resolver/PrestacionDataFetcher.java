package com.vyjsoft.resolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vyjsoft.model.Prestacion;
import com.vyjsoft.repository.PrestacionRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class PrestacionDataFetcher implements DataFetcher<Prestacion> {

	@Autowired
	private PrestacionRepository prestacionRP;
	
	@Override
	public Prestacion get(DataFetchingEnvironment environment) {
		Long id = environment.getArgument("id"); 
		return prestacionRP.findById(id).orElse(new Prestacion());
	}

}
