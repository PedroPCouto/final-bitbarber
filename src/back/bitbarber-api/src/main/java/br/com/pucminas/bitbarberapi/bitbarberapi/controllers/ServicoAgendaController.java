package br.com.pucminas.bitbarberapi.bitbarberapi.controllers;

import br.com.pucminas.bitbarberapi.bitbarberapi.dtos.CreateNewApoitmentDTO;
import br.com.pucminas.bitbarberapi.bitbarberapi.dtos.RegisterIdleTimeDTO;
import br.com.pucminas.bitbarberapi.bitbarberapi.response.GenericResponse;
import br.com.pucminas.bitbarberapi.bitbarberapi.services.ServicoAgendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/apointment")

public class ServicoAgendaController {
    private final ServicoAgendaService service;

    public ServicoAgendaController(ServicoAgendaService service){
        this.service = service;
    }

    @GetMapping(value = "/getForScheduling")
    public ResponseEntity<?> getForScheduling(@RequestParam(value = "data") LocalDate data, @RequestParam(value = "barbeiro") String barbeiro){
        return ResponseEntity.ok(service.getAllByBarbeiroEmailAndDataMarcada(barbeiro, data));
    }

    @PostMapping(value = "/createNewApointment")
    public ResponseEntity<?> createNewApointment(@RequestBody CreateNewApoitmentDTO dto){
        try {
            service.createNewApointment(dto);
            return ResponseEntity.ok(new GenericResponse("Seu agendamento foi registrado", true));
        }catch(Exception e) {
            return ResponseEntity.internalServerError().body(new GenericResponse("Ocorreu um erro, tente novamente mais tarde", false));
        }
    }

    @GetMapping(value = "/getNewApointments")
    public ResponseEntity<?> getNewApointments(@RequestParam(value = "clientId") String email){
        try{

            return ResponseEntity.ok(service.getNewApointments(email));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(new GenericResponse("Ocorreu um erro, tente novamente mais tarde", false));
        }
    }

    @GetMapping(value = "/getPastApointments")
    public ResponseEntity<?> getPastApointments(@RequestParam(value = "clientId") String email){
        try{

            return ResponseEntity.ok(service.getPastApointments(email));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(new GenericResponse("Ocorreu um erro, tente novamente mais tarde", false));
        }
    }

    @PostMapping(value = "/registerIdleTime")
    public ResponseEntity<?> registerIdleTime(@RequestBody RegisterIdleTimeDTO dto){
        try {
            service.registerIdleTime(dto);
            return ResponseEntity.ok(new GenericResponse("Seu Horário foi oculto de sua agenda", true));
        }catch(Exception e) {
            return ResponseEntity.internalServerError().body(new GenericResponse("Ocorreu um erro, tente novamente mais tarde", false));
        }
    }

    @GetMapping(value = "/obterQuantidadeServicosPorFeedback")
    public ResponseEntity<?> obterQuantidadeServicosPorFeedback() {
        return ResponseEntity.ok(service.obterQuantidadeServicosPorFeedback());
    }

    @GetMapping(value = "/getQuantidadeServicosPorMes")
    public ResponseEntity<?> getQuantidadeServicosPorMes(){
        return ResponseEntity.ok(service.getAllByMonth());
    }
}
