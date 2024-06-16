package br.com.pucminas.bitbarberapi.bitbarberapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class LoginDTO {
    public String email;
    public String senha;
}
