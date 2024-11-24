package com.medvoll.apirest.repository;

import com.medvoll.apirest.Model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
}
