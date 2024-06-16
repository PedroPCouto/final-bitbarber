package br.com.pucminas.bitbarberapi.bitbarberapi.controllers;

import br.com.pucminas.bitbarberapi.bitbarberapi.response.GenericResponse;
import br.com.pucminas.bitbarberapi.bitbarberapi.dtos.RegisterDTO;
import br.com.pucminas.bitbarberapi.bitbarberapi.exceptions.LoginException;
import br.com.pucminas.bitbarberapi.bitbarberapi.services.ClienteService;
import ch.qos.logback.core.encoder.EchoEncoder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {
    private ClienteService service;

    public ClienteController(ClienteService service){
        this.service = service;
    }

    @GetMapping(value = "/login")
    public ResponseEntity<?> loginCliente(@RequestParam(value = "email") String email, @RequestParam(value = "senha") String senha){
        try{

            return ResponseEntity.ok(service.encontrarUsuario(email, senha));
        }catch(LoginException e){
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping(value = "/register")
    public ResponseEntity<GenericResponse> registrarCliente(@RequestBody RegisterDTO dto){

        return ResponseEntity.ok().body(service.createNewCliente(dto));
    }

    @GetMapping(value = "/getClientesAusentes")
    public ResponseEntity<?> getClientesAusentes(@RequestParam(value = "days") String days) {
        try{
            return ResponseEntity.ok().body(service.getClientesAusentes(days));

        }catch (Exception e) {
            return ResponseEntity.internalServerError().body(new GenericResponse("Erro", false));
        }
    }

    @GetMapping(value = "/getQuantidadeClientesPorMes")
    public ResponseEntity<?> getQuantidadeClientesPorMes() {
        return ResponseEntity.ok(service.getQuantidadeClientesPorMes());
    }
}
