package com.vyjsoft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vyjsoft.model.Nomenclador;

public interface NomencladorRepository extends JpaRepository<Nomenclador, Long> {
	Optional <Nomenclador> findByCodigo(String codigo);
    void deleteByCodigo(String codigo);
}
