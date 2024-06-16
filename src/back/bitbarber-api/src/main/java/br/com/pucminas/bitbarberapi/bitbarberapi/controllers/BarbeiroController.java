package br.com.pucminas.bitbarberapi.bitbarberapi.controllers;

import br.com.pucminas.bitbarberapi.bitbarberapi.services.BarbeiroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/barbeiro")
public class BarbeiroController {

    private BarbeiroService service;

    public BarbeiroController(BarbeiroService service){
        this.service = service;
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<?>  getAllBarbeiros(){
        return ResponseEntity.ok(service.getAllBarbeiros());
    }
}
