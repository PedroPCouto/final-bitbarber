package br.com.pucminas.bitbarberapi.bitbarberapi.services;


import br.com.pucminas.bitbarberapi.bitbarberapi.dtos.CreateNewApoitmentDTO;
import br.com.pucminas.bitbarberapi.bitbarberapi.dtos.RegisterIdleTimeDTO;
import br.com.pucminas.bitbarberapi.bitbarberapi.models.Cliente;
import br.com.pucminas.bitbarberapi.bitbarberapi.models.Cupom;
import br.com.pucminas.bitbarberapi.bitbarberapi.models.ServicoAgenda;
import br.com.pucminas.bitbarberapi.bitbarberapi.repositories.ICupomRepository;
import br.com.pucminas.bitbarberapi.bitbarberapi.repositories.IServicoAgendaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ServicoAgendaService {

    private final IServicoAgendaRepository repository;
    private final BarbeiroService barbeiroService;
    private final ClienteService clienteService;

    private final ICupomRepository cupomRepository;


    public ServicoAgendaService(IServicoAgendaRepository repository, BarbeiroService barbeiroService, ClienteService clienteService, ICupomRepository cupomRepository) {
        this.repository = repository;
        this.barbeiroService = barbeiroService;
        this.clienteService = clienteService;
        this.cupomRepository = cupomRepository;
    }

    public List<ServicoAgenda> getAllByBarbeiroEmailAndDataMarcada(String emailBarbeiro, LocalDate dataMarcada) {
        return repository.getAllByBarbeiroEmailAndDataMarcada(emailBarbeiro, dataMarcada);
    }

    public void createNewApointment(CreateNewApoitmentDTO dto) {

        ServicoAgenda servicoAgenda = new ServicoAgenda();
        servicoAgenda.setHora(dto.getHorario());
        servicoAgenda.setBarbeiro(barbeiroService.getBarbeiroByEmail(dto.getBarbeiro()));
        servicoAgenda.setCliente(clienteService.getClienteByEmail(dto.getCliente()));
        servicoAgenda.setDataMarcada(dto.getData());
        servicoAgenda.setCreated_date(LocalDate.now());
        if(dto.getCupom() != null) {
            Optional<Cupom> cOp = cupomRepository.findById(dto.getCupom());
            if(cOp.isPresent()) {
                Cupom c = cOp.get();
                c.setUsado(true);
                cupomRepository.save(c);
                servicoAgenda.setCupom(c);
            }
        }
        repository.save(servicoAgenda);
    }

    public void registerIdleTime(RegisterIdleTimeDTO dto) {
        ServicoAgenda servicoAgenda = new ServicoAgenda();
        servicoAgenda.setHora(dto.getHorario());
        servicoAgenda.setBarbeiro(barbeiroService.getBarbeiroByEmail(dto.getBarbeiro()));
        servicoAgenda.setDataMarcada(dto.getData());
        repository.save(servicoAgenda);
    }

    public ServicoAgenda getServicoAgendaById(Long servicoAgendaId) {
        return repository.findById(servicoAgendaId).get();
    }

    public List<ServicoAgenda> getNewApointments(String email) {
        return repository.getAllByClienteEmailAndDataMarcadaIsGreaterThan(email, LocalDate.now());
    }

    public List<ServicoAgenda> getPastApointments(String email) {
        return repository.getAllByClienteEmailAndDataMarcadaLessThan(email, LocalDate.now());
    }

    public Map<String, Integer> obterQuantidadeServicosPorFeedback() {
        Map<String, Integer> mapQntServicoAg = new HashMap<>();
        mapQntServicoAg.put("possui_feedback", 0);
        mapQntServicoAg.put("nao_possui", 0);
        List<ServicoAgenda> servicosAgendados = repository.findAll();
        for(ServicoAgenda s : servicosAgendados) {
            if(s.getFeedback() == null) {
                mapQntServicoAg.merge("nao_possui", 1, Integer::sum);
            }else {
                mapQntServicoAg.merge("possui_feedback", 1, Integer::sum);
            }
        }
        return mapQntServicoAg;
    }

    public List<Integer> getAllByMonth() {
        List<ServicoAgenda> servicoAgendas = repository.findAll();
        Map<Integer, Integer> quantidadePorMes = new HashMap<>();
        for(int i = 1; i <= 12; i++){
            quantidadePorMes.put(i, 0);
        }
        for(ServicoAgenda c : servicoAgendas){
            quantidadePorMes.merge(c.getCreated_date().getMonthValue(), 1, Integer::sum);
        }
        quantidadePorMes.put(13, servicoAgendas.size());
        return quantidadePorMes.values().stream().toList();
    }
}
