package br.com.pucminas.bitbarberapi.bitbarberapi.controllers;

import br.com.pucminas.bitbarberapi.bitbarberapi.dtos.CupomDTO;
import br.com.pucminas.bitbarberapi.bitbarberapi.models.Cupom;
import br.com.pucminas.bitbarberapi.bitbarberapi.response.GenericResponse;
import br.com.pucminas.bitbarberapi.bitbarberapi.services.CupomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/cupom")
public class CupomController {

    private CupomService service;

    public CupomController(CupomService service) {
        this.service = service;
    }

    @PostMapping(value = "/createCupom")
    public ResponseEntity<?> createCoupon(@RequestBody CupomDTO dto) {
        try {
            service.registerCupom(dto);
            return ResponseEntity.ok(new GenericResponse("Seu cupom foi registrado", true));
        } catch (Exception e) {
            System.out.println(e.toString());
            return ResponseEntity.internalServerError().body(new GenericResponse("Ocorreu um erro, tente novamente mais tarde", false));
        }
    }

    @GetMapping(value = "/getCuponsByCliente")
    public ResponseEntity<?> getCuponsByCliente(@RequestParam(value = "email") String email) {
        return ResponseEntity.ok(service.getAllValidNotExpiredCupons(email));
    }

    @GetMapping(value = "/obterCuponsPorStatus")
    public ResponseEntity<?> obterCuponsPorStatus() {
        try{
            return ResponseEntity.ok(service.obterCuponsPorStatus());
        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.internalServerError().body(new GenericResponse("Erro", false));
        }
    }
}
