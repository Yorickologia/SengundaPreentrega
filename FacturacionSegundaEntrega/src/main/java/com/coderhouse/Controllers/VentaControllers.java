package com.coderhouse.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.Services.VentasService;
import com.coderhouse.modelos.Ventas;

@RestController
@RequestMapping("/ventas")
public class VentaControllers {

    @Autowired
    private VentasService ventasService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ventas>> listarVentas() {
        List<Ventas> ventas = ventasService.listarVentas();
        return new ResponseEntity<>(ventas, HttpStatus.OK);
    }

    @GetMapping(value = "/{nroDeTicket}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ventas> mostrarVentaPorNroDeTicket(@PathVariable("nroDeTicket") Integer nroDeTicket) {
        Ventas venta = ventasService.mostrarVentaPorNroDeTicket(nroDeTicket);
        if (venta != null) {
            return new ResponseEntity<>(venta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/agregar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ventas> agregarVenta(@RequestBody Ventas venta) {
        ventasService.agregarVenta(venta);
        return new ResponseEntity<>(venta, HttpStatus.CREATED);
    }
}
