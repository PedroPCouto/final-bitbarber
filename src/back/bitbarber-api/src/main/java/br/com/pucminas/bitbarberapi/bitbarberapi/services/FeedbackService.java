package br.com.pucminas.bitbarberapi.bitbarberapi.services;

import br.com.pucminas.bitbarberapi.bitbarberapi.dtos.CreateFeedbackDTO;
import br.com.pucminas.bitbarberapi.bitbarberapi.dtos.RegisterIdleTimeDTO;
import br.com.pucminas.bitbarberapi.bitbarberapi.models.Feedback;
import br.com.pucminas.bitbarberapi.bitbarberapi.models.Servico;
import br.com.pucminas.bitbarberapi.bitbarberapi.models.ServicoAgenda;
import br.com.pucminas.bitbarberapi.bitbarberapi.repositories.IFeedbackRepository;
import br.com.pucminas.bitbarberapi.bitbarberapi.repositories.IServicoAgendaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FeedbackService {

    private final IFeedbackRepository repository;
    private final IServicoAgendaRepository servicoAgendaRepository;
    private final ServicoAgendaService servicoAgendaService;


    public void registerFeedback(CreateFeedbackDTO dto) {
        ServicoAgenda apointment = servicoAgendaService.getServicoAgendaById(dto.getServicoAgenda());


        Feedback newFeedBack = new Feedback();
        newFeedBack.setNota(dto.getAvaliacao());
        newFeedBack.setComentario(dto.getComentario());
        repository.save(newFeedBack);

        apointment.setFeedback(newFeedBack);
        servicoAgendaRepository.save(apointment);
    }
}
