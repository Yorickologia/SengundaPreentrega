package com.coderhouse.Services;

import com.coderhouse.Repository.VentasRepository;
import com.coderhouse.modelos.Ventas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Ventas actualizarVenta(Ventas venta) {
        return ventasRepository.save(venta);
    }

    public void eliminarVenta(Integer nroDeTicket) {
        ventasRepository.deleteById(nroDeTicket);
    }
}
