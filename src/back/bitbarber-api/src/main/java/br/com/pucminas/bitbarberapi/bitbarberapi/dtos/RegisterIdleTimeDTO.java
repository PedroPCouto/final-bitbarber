package br.com.pucminas.bitbarberapi.bitbarberapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterIdleTimeDTO {

    private String barbeiro;
    private int horario;
    private LocalDate data;
}
