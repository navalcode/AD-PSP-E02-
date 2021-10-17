package com.salesianostriana.Ejercicio2.respositorios;

import com.salesianostriana.Ejercicio2.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Long> {
}
