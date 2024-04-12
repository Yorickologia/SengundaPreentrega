package com.coderhouse.Controllers;

import com.coderhouse.modelos.Producto;
import com.coderhouse.Services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Producto>> listarProductos() {
        List<Producto> productos = productoService.listarProductos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> mostrarProductoPorId(@PathVariable("id") Integer id) {
        Producto producto = productoService.mostrarProductoPorId(id);
        if (producto != null) {
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/agregar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> agregarProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoService.agregarProducto(producto);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    public static class ProductoConDetalle {
        private Integer id;
        private String nombre;
        private Integer precio;

        public ProductoConDetalle(Integer id, String nombre, Integer precio) {
            this.id = id;
            this.nombre = nombre;
            this.precio = precio;
        }

        public Integer getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public Integer getPrecio() {
            return precio;
        }
    }

    @GetMapping(value = "/detalles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductoConDetalle> mostrarDetalleProducto(@PathVariable("id") Integer id) {
        Producto producto = productoService.mostrarProductoPorId(id);
        if (producto != null) {
            ProductoConDetalle detalle = new ProductoConDetalle(producto.getId(), producto.getNombre(), producto.getPrecio());
            return new ResponseEntity<>(detalle, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> actualizarProducto(@PathVariable("id") Integer id, @RequestBody Producto producto) {
        Producto productoExistente = productoService.mostrarProductoPorId(id);
        if (productoExistente != null) {
            productoExistente.setNombre(producto.getNombre());
            productoExistente.setPrecio(producto.getPrecio());
            return new ResponseEntity<>(productoService.actualizarProducto(productoExistente), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable("id") Integer id) {
        Producto producto = productoService.mostrarProductoPorId(id);
        if (producto != null) {
            productoService.eliminarProducto(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
