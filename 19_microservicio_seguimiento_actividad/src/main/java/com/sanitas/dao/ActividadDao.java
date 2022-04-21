package com.sanitas.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.sanitas.model.Actividad;

public interface ActividadDao extends JpaRepository<Actividad, Integer> {
	
	List<Actividad> findByIpOrigen(String ip);
	List<Actividad> findByRecurso(String recurso);
	Optional<Actividad>findByIpOrigenAndRecursoAndFecha(String ip, String recurso, Date fecha);
	@Transactional
	@Modifying
	int deleteByIpOrigen(String ip);
}
