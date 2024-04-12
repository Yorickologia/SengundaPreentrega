package com.coderhouse.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.coderhouse.Repository.ClienteRepository;
import com.coderhouse.modelos.Cliente;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente mostrarClientePorDni(Integer dni) {
        return clienteRepository.findById(dni).orElse(null);
    }

    public Cliente agregarCliente(Cliente cliente) {
        try {
            return clienteRepository.save(cliente);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Cliente actualizarCliente(Integer dni, Cliente cliente) {
        Cliente clienteExistente = clienteRepository.findById(dni).orElse(null);
        if (clienteExistente != null) {
            clienteExistente.setNombre(cliente.getNombre());
            clienteExistente.setCorreoElectronico(cliente.getCorreoElectronico());
            return clienteRepository.save(clienteExistente);
        } else {
            return null; 
        }
    }

    public void eliminarCliente(Integer dni) {
        clienteRepository.deleteById(dni);
    }
}
