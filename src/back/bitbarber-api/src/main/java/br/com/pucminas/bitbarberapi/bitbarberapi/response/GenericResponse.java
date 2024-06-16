package br.com.pucminas.bitbarberapi.bitbarberapi.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class GenericResponse {
    public String message;
    public Boolean result;
}
