package br.com.pucminas.bitbarberapi.bitbarberapi.services;

import br.com.pucminas.bitbarberapi.bitbarberapi.response.GenericResponse;
import br.com.pucminas.bitbarberapi.bitbarberapi.response.LoginResponseDTO;
import br.com.pucminas.bitbarberapi.bitbarberapi.dtos.RegisterDTO;
import br.com.pucminas.bitbarberapi.bitbarberapi.exceptions.LoginException;
import br.com.pucminas.bitbarberapi.bitbarberapi.models.Cliente;
import br.com.pucminas.bitbarberapi.bitbarberapi.repositories.IClienteRepository;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class ClienteService {

    private final IClienteRepository repository;


    public ClienteService(IClienteRepository repository){
        this.repository = repository;
    }

    public List<Cliente> encontrarClientesPorEmails(List<String> emails) {
        return repository.findAllById(emails);
    }
    public LoginResponseDTO encontrarUsuario(String email, String senha) throws LoginException {

        Cliente c = repository.findClienteByEmailAndSenha(email, senha);
        if(c != null) {
            return new LoginResponseDTO("Cliente encontrado com sucesso", new LoginResponseDTO.InfoPerfil("Cliente", c.getNome(), c.getEmail()));
        }

        throw new LoginException("Cliente não encontrado");
    }

    public Cliente getClienteByEmail(String email) {
        return repository.findClienteByEmail(email);
    }

    public GenericResponse createNewCliente(RegisterDTO dto) {
        Cliente c = repository.findClienteByEmail(dto.getEmail());
        if(c != null) {
            return new GenericResponse("Já existe um usuário com essas credenciais", false);
        }
        Cliente novoCliente = new Cliente(dto.getEmail(), dto.getNome(), dto.getSenha(), dto.getDataAniversario(), LocalDate.now());
        repository.save(novoCliente);
        return new GenericResponse("Cliente criado com sucesso", true);
    }

    public List<Cliente> getClientesAusentes(String days) {
        int daysInt = Integer.parseInt(days);

        LocalDate endDate = LocalDate.now().minusDays(daysInt);
        LocalDate startDate = LocalDate.now().minusDays(daysInt + 29);
        return repository.findClientesWithRecentServicoAgenda(startDate, endDate);
    }

    public List<Integer> getQuantidadeClientesPorMes() {
        List<Cliente> clientes = repository.findAll();
        Map<Integer, Integer> quantidadePorMes = new HashMap<>();
        for(int i = 1; i <= 12; i++){
            quantidadePorMes.put(i, 0);
        }
        for(Cliente c : clientes){
            quantidadePorMes.merge(c.getCreatedDate().getMonthValue(), 1, Integer::sum);
        }
        quantidadePorMes.put(13, clientes.size());
        return  quantidadePorMes.values().stream().toList();
    }
}
