package br.com.pucminas.bitbarberapi.bitbarberapi.exceptions;

import java.io.IOException;

public class LoginException extends IOException {
    public LoginException(String error){
        super(error);
    }
}
