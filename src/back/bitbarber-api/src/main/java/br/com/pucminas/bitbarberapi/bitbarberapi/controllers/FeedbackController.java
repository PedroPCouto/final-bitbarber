package br.com.pucminas.bitbarberapi.bitbarberapi.controllers;

import br.com.pucminas.bitbarberapi.bitbarberapi.dtos.CreateFeedbackDTO;
import br.com.pucminas.bitbarberapi.bitbarberapi.dtos.CreateNewApoitmentDTO;
import br.com.pucminas.bitbarberapi.bitbarberapi.response.GenericResponse;
import br.com.pucminas.bitbarberapi.bitbarberapi.services.FeedbackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private FeedbackService service;

    public FeedbackController(FeedbackService service){
        this.service = service;
    }

    @PostMapping(value = "/createNewFeedback")
    public ResponseEntity<?> createNewFeedback(@RequestBody CreateFeedbackDTO dto){
        try {
            service.registerFeedback(dto);
            return ResponseEntity.ok(new GenericResponse("Seu feedback foi registrado", true));
        }catch(Exception e) {
            return ResponseEntity.internalServerError().body(new GenericResponse("Ocorreu um erro, tente novamente mais tarde", false));
        }
    }

}
