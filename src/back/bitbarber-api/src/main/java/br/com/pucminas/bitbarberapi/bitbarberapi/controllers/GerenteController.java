package br.com.pucminas.bitbarberapi.bitbarberapi.controllers;

import br.com.pucminas.bitbarberapi.bitbarberapi.exceptions.LoginException;
import br.com.pucminas.bitbarberapi.bitbarberapi.services.GerenteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gerente")
public class GerenteController {

    private GerenteService service;

    public GerenteController(GerenteService service) {
        this.service = service;
    }

    @GetMapping(value = "/login")
    public ResponseEntity<?> loginGerente(@RequestParam(value = "email") String email, @RequestParam(value = "senha") String senha){
        try{

            return ResponseEntity.ok(service.encontrarUsuario(email, senha));
        }catch(LoginException e){
            return ResponseEntity.notFound().build();
        }

    }
}
