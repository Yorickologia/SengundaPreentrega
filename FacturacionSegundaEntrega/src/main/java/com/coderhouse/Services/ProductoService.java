package com.coderhouse.Services;

import com.coderhouse.modelos.Producto;
import com.coderhouse.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Producto mostrarProductoPorId(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Producto agregarProducto(Producto producto) {
        return productoRepository.save(producto);
    }
}
