package br.com.pucminas.bitbarberapi.bitbarberapi.services;

import br.com.pucminas.bitbarberapi.bitbarberapi.models.Barbeiro;
import br.com.pucminas.bitbarberapi.bitbarberapi.repositories.IBarbeiroRepository;
import br.com.pucminas.bitbarberapi.bitbarberapi.repositories.IClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarbeiroService {

    private final IBarbeiroRepository repository;


    public BarbeiroService(IBarbeiroRepository repository){
        this.repository = repository;
    }

    public List<Barbeiro> getAllBarbeiros(){
        return repository.findAll();
    }

    public Barbeiro getBarbeiroByEmail(String email){
        return repository.getBarbeiroByEmail(email);
    }
}
