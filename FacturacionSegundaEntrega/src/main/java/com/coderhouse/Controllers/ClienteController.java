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

import com.coderhouse.Services.ClienteService;
import com.coderhouse.Services.ClienteService.ClienteInfo;
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

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> mostrarClientePorId(@PathVariable("id") Integer id) {
        Cliente cliente = clienteService.mostrarClientePorDNI(id);
        if (cliente != null) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/agregar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> agregarCliente(@RequestBody Cliente cliente) {
        clienteService.agregarCliente(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    @GetMapping(value = "/info/{dni}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClienteInfo> mostrarInformacionCliente(@PathVariable("dni") Integer dni) {
        ClienteInfo clienteInfo = clienteService.mostrarInformacionCliente(dni);
        if (clienteInfo != null) {
            return new ResponseEntity<>(clienteInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

