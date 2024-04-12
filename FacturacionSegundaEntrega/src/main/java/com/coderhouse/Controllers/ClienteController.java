package com.coderhouse.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.coderhouse.Services.ClienteService;
import com.coderhouse.modelos.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.listarClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping(value = "/{dni}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> mostrarClientePorDNI(@PathVariable("dni") Integer dni) {
        Cliente cliente = clienteService.mostrarClientePorDni(dni);
        if (cliente != null) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/agregar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> agregarCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.agregarCliente(cliente);
        if (nuevoCliente != null) {
            return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
        Cliente clienteActualizado = clienteService.actualizarCliente(id, cliente);
        if (clienteActualizado != null) {
            return new ResponseEntity<>(clienteActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable("id") Integer id) {
        clienteService.eliminarCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
