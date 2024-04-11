package com.coderhouse.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.Repository.VentasRepository;
import com.coderhouse.modelos.Ventas;

@Service
public class VentasService {

    @Autowired
    private VentasRepository ventasRepository;

    public List<Ventas> listarVentas() {
        return ventasRepository.findAll();
    }

    public Ventas mostrarVentaPorNroDeTicket(Integer nroDeTicket) {
        return ventasRepository.findById(nroDeTicket).orElse(null);
    }

    public Ventas agregarVenta(Ventas venta) {
        return ventasRepository.save(venta);
    }
}
