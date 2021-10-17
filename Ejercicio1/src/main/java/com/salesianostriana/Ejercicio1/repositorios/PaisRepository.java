package com.salesianostriana.Ejercicio1.repositorios;

import com.salesianostriana.Ejercicio1.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<Pais, Long> {
}
