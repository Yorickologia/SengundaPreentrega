package com.coderhouse.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.coderhouse.modelos.Ventas;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Integer> {

}
