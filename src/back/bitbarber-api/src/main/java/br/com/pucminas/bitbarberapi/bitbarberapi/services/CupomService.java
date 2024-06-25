package br.com.pucminas.bitbarberapi.bitbarberapi.services;


import br.com.pucminas.bitbarberapi.bitbarberapi.dtos.CupomDTO;
import br.com.pucminas.bitbarberapi.bitbarberapi.models.Cliente;
import br.com.pucminas.bitbarberapi.bitbarberapi.models.Cupom;
import br.com.pucminas.bitbarberapi.bitbarberapi.repositories.ICupomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CupomService {

    private final ICupomRepository repository;
    private final ClienteService clienteService;

    public CupomService(ICupomRepository repository, ClienteService clienteService){
        this.repository = repository;
        this.clienteService = clienteService;
    }

    public void registerCupom(CupomDTO dto) {
        List<Cliente> clientes = clienteService.encontrarClientesPorEmails(dto.getSelectedUsers());
        List<Cupom> cupons = new ArrayList<>();
        for(Cliente c : clientes){
            Cupom cupom = new Cupom();
            cupom.setCliente(c);
            cupom.setDesconto(dto.getDesconto());
            cupom.setNomeCupom(dto.getNomeCupom());
            cupom.setDataExpiracao(dto.getDataCupom());
            cupom.setUsado(false);
            cupons.add(cupom);
        }
        repository.saveAll(cupons);
    }

    public Map<String, Integer> obterCuponsPorStatus(){
        Map<String, Integer> cuponsPorStatus = new HashMap<>();
        cuponsPorStatus.put("nao_usados_expirados", 0);
        cuponsPorStatus.put("nao_usados_validos", 0);
        cuponsPorStatus.put("usados", 0);
        List<Cupom> allCupons = repository.findAll();
        for(Cupom c : allCupons) {
            if(c.getUsado()) cuponsPorStatus.merge("usados",1, Integer::sum);
            else if(c.getDataExpiracao().isAfter(LocalDate.now())) cuponsPorStatus.merge("nao_usados_expirados",1, Integer::sum);
            else cuponsPorStatus.merge("nao_usados_validos",1, Integer::sum);
        }
        return cuponsPorStatus;
    }

    public List<Cupom> getAllValidNotExpiredCupons(String email) {
        return repository.findAllValidNotExpiredCuponsByCustomer(email, LocalDate.now());
    }
}
