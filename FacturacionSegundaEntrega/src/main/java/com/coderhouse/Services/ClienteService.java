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

	public Cliente mostrarClientePorDNI(Integer dni) {
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
	public ClienteInfo mostrarInformacionCliente(Integer dni) {
        Cliente cliente = clienteRepository.findById(dni).orElse(null);
        if (cliente != null) {
            String nombre = cliente.getNombre();
            String correoElectronico = cliente.getCorreoElectronico();
            return new ClienteInfo(nombre, correoElectronico);
        } else {
            return null;
        }
    }

    public static class ClienteInfo {
        private String nombre;
        private String correoElectronico;

        public ClienteInfo(String nombre, String correoElectronico) {
            this.nombre = nombre;
            this.correoElectronico = correoElectronico;
        }

        public String getNombre() {
            return nombre;
        }

        public String getCorreoElectronico() {
            return correoElectronico;
        }
    }
}

