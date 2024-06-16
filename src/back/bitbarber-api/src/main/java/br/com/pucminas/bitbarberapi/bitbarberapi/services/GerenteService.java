package br.com.pucminas.bitbarberapi.bitbarberapi.services;

import br.com.pucminas.bitbarberapi.bitbarberapi.exceptions.LoginException;
import br.com.pucminas.bitbarberapi.bitbarberapi.models.Gerente;
import br.com.pucminas.bitbarberapi.bitbarberapi.repositories.IGerenteRepository;
import br.com.pucminas.bitbarberapi.bitbarberapi.response.LoginResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class GerenteService {

    private final IGerenteRepository repository;

    public GerenteService(IGerenteRepository repository) {
        this.repository = repository;
    }

    public LoginResponseDTO encontrarUsuario(String email, String senha) throws LoginException {

        Gerente c = repository.findClienteByEmailAndSenha(email, senha);
        if(c != null) {
            return new LoginResponseDTO("Cliente encontrado com sucesso", new LoginResponseDTO.InfoPerfil("Cliente", c.getNome(), c.getEmail()));
        }

        throw new LoginException("Cliente não encontrado");
    }
}
