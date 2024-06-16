package br.com.pucminas.bitbarberapi.bitbarberapi.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDTO {
    private String message;
    private InfoPerfil infos;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InfoPerfil{
        private String tipoPerfil;
        private String nomeUsuario;
        private String email;
    }
}
