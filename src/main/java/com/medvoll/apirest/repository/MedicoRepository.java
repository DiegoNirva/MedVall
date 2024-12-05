package com.medvoll.apirest.repository;

import com.medvoll.apirest.Model.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    Page<Medico> findByActivoTrue(Pageable pageable);
}
