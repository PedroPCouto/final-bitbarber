package br.com.pucminas.bitbarberapi.bitbarberapi.dtos;

import br.com.pucminas.bitbarberapi.bitbarberapi.models.ServicoAgenda;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class RegisterDTO {
    private String email;
    private String nome;
    private String senha;
    private LocalDate dataAniversario;
}
