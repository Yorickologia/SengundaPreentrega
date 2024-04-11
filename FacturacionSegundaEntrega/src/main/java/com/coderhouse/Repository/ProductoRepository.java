package com.coderhouse.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.coderhouse.modelos.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
