package br.com.pucminas.bitbarberapi.bitbarberapi.dtos;

import br.com.pucminas.bitbarberapi.bitbarberapi.models.Cupom;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateNewApoitmentDTO {
    private String barbeiro;
    private String cliente;
    private int horario;
    private LocalDate data;
    private String servico;
    private Long cupom;
}
