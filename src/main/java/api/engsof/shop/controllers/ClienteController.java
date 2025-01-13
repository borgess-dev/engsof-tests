package api.engsof.shop.controllers;

import api.engsof.shop.entities.Cliente;
import api.engsof.shop.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/post")
    public ResponseEntity<Cliente> post(@RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.clienteService.cadastrarCliente(cliente));
    }
}
