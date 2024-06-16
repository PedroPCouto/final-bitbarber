package br.com.pucminas.bitbarberapi.bitbarberapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateFeedbackDTO {

    private long servicoAgenda;
    private int avaliacao;
    private String comentario;
}
