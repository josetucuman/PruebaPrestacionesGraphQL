package com.vyjsoft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vyjsoft.model.Prestacion;

public interface PrestacionRepository extends JpaRepository<Prestacion, Long> {
	
    Optional <Prestacion> findByCodigo(String codigo);
    void deleteByCodigo(String codigo);
}
