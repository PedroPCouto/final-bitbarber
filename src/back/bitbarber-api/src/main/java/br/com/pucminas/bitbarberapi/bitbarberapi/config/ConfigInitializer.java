package br.com.pucminas.bitbarberapi.bitbarberapi.config;

import br.com.pucminas.bitbarberapi.bitbarberapi.models.*;
import br.com.pucminas.bitbarberapi.bitbarberapi.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ConfigInitializer implements ApplicationRunner {

    private final IBarbeiroRepository barbeiroRepository;
    private final IServicoAgendaRepository servicoAgendaRepository;
    private final IClienteRepository clienteRepository;
    private  final IGerenteRepository gerenteRepository;
    private final IFeedbackRepository feedbackRepository;
    private final ICupomRepository cupomRepository;


    @Autowired
    public ConfigInitializer(IBarbeiroRepository barbeiroRepository, IServicoAgendaRepository servicoAgendaRepository, IClienteRepository clienteRepository, IGerenteRepository gerenteRepository, IFeedbackRepository feedbackRepository, ICupomRepository cupomRepository) {
        this.clienteRepository = clienteRepository;
        this.barbeiroRepository = barbeiroRepository;
        this.servicoAgendaRepository = servicoAgendaRepository;
        this.gerenteRepository = gerenteRepository;
        this.feedbackRepository = feedbackRepository;
        this.cupomRepository = cupomRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Cliente cliente = new Cliente();
        cliente.setEmail("pedrohpaiva1258@gmail.com");
        cliente.setNome("Pedro");
        cliente.setSenha("phpc1258");
        cliente.setDataAniversario(LocalDate.now());
        cliente.setCreatedDate(LocalDate.now());
        clienteRepository.save(cliente);

        Cliente cliente2 = new Cliente();
        cliente2.setEmail("gustavo.pessoa@gmail.com");
        cliente2.setNome("Gustavo");
        cliente2.setSenha("phpc1258");
        cliente2.setDataAniversario(LocalDate.now());
        cliente2.setCreatedDate(LocalDate.now().minusMonths(1));

        clienteRepository.save(cliente2);

        Cliente cliente3 = new Cliente();
        cliente3.setEmail("bruna.lopes@gmail.com");
        cliente3.setNome("Bruna");
        cliente3.setSenha("phpc1258");
        cliente3.setDataAniversario(LocalDate.now());
        cliente3.setCreatedDate(LocalDate.now().minusMonths(2));

        clienteRepository.save(cliente3);

        Cliente cliente4 = new Cliente();
        cliente4.setEmail("Livia.bontempo@gmail.com");
        cliente4.setNome("Livia");
        cliente4.setSenha("phpc1258");
        cliente4.setDataAniversario(LocalDate.now());
        cliente4.setCreatedDate(LocalDate.now());
        clienteRepository.save(cliente4);

        Cliente cliente5 = new Cliente();
        cliente5.setEmail("joao.silva@gmail.com");
        cliente5.setNome("Joao");
        cliente5.setSenha("phpc1258");
        cliente5.setDataAniversario(LocalDate.now());
        cliente5.setCreatedDate(LocalDate.now().minusMonths(2));

        clienteRepository.save(cliente5);

        Cliente cliente6 = new Cliente();
        cliente6.setEmail("maria.lopes@gmail.com");
        cliente6.setNome("Maria");
        cliente6.setSenha("phpc1258");
        cliente6.setDataAniversario(LocalDate.now());
        cliente6.setCreatedDate(LocalDate.now().minusMonths(2));

        clienteRepository.save(cliente6);

        Barbeiro barbeiro = new Barbeiro();
        barbeiro.setEmail("pedro.couto@bitbarber.com.br");
        barbeiro.setNome("Pedro Couto");
        barbeiro.setSenha("password");
        barbeiro.setNotaMedia("5.0");
        barbeiro.setProfilPictureURL("https://static.vecteezy.com/system/resources/previews/025/744/378/original/a-man-with-a-fashionable-haircut-in-profile-a-logo-for-a-barber-shop-vector.jpg");
        barbeiroRepository.save(barbeiro);

        ServicoAgenda servicoAgenda = new ServicoAgenda();
        servicoAgenda.setHora(18);
        servicoAgenda.setBarbeiro(barbeiro);
        servicoAgenda.setDataMarcada(LocalDate.now().minusWeeks(1));
        servicoAgenda.setCliente(cliente);
        servicoAgenda.setCreated_date(LocalDate.now());

        servicoAgendaRepository.save(servicoAgenda);

        ServicoAgenda servicoAgenda2 = new ServicoAgenda();
        servicoAgenda2.setHora(18);
        servicoAgenda2.setBarbeiro(barbeiro);
        servicoAgenda2.setDataMarcada(LocalDate.now().minusWeeks(3));
        servicoAgenda2.setCliente(cliente);
        servicoAgenda2.setCreated_date(LocalDate.now());

        servicoAgendaRepository.save(servicoAgenda2);


        ServicoAgenda servicoAgenda3 = new ServicoAgenda();
        servicoAgenda3.setHora(18);
        servicoAgenda3.setBarbeiro(barbeiro);
        servicoAgenda3.setDataMarcada(LocalDate.now().minusWeeks(5));
        servicoAgenda3.setCliente(cliente);
        servicoAgenda3.setCreated_date(LocalDate.now().minusMonths(2));

        servicoAgendaRepository.save(servicoAgenda3);


        ServicoAgenda servicoAgenda4 = new ServicoAgenda();
        servicoAgenda4.setHora(18);
        servicoAgenda4.setBarbeiro(barbeiro);
        servicoAgenda4.setDataMarcada(LocalDate.now());
        servicoAgenda4.setCliente(cliente);
        servicoAgenda4.setCreated_date(LocalDate.now().minusMonths(1));

        servicoAgendaRepository.save(servicoAgenda4);

        ServicoAgenda servicoAgenda5 = new ServicoAgenda();
        servicoAgenda5.setHora(18);
        servicoAgenda5.setBarbeiro(barbeiro);
        servicoAgenda5.setDataMarcada(LocalDate.now().minusDays(30));
        servicoAgenda5.setCliente(cliente2);
        servicoAgenda5.setCreated_date(LocalDate.now().minusMonths(2));

        servicoAgendaRepository.save(servicoAgenda5);

        ServicoAgenda servicoAgenda6 = new ServicoAgenda();
        servicoAgenda6.setHora(18);
        servicoAgenda6.setBarbeiro(barbeiro);
        servicoAgenda6.setDataMarcada(LocalDate.now().minusDays(30));
        servicoAgenda6.setCliente(cliente3);
        servicoAgenda6.setCreated_date(LocalDate.now().minusMonths(1));

        servicoAgendaRepository.save(servicoAgenda6);

        Feedback f = new Feedback();
        f.setComentario("Ficou paia");
        f.setNota(3);
        feedbackRepository.save(f);

        servicoAgenda6.setFeedback(f);
        servicoAgendaRepository.save(servicoAgenda6);

        Gerente g = new Gerente();
        g.setEmail("pedro@bitbarberadmin.com.br");
        g.setNome("Pedro");
        g.setSenha("phpc1258");
        gerenteRepository.save(g);

        Cupom c = new Cupom();
        c.setGerente(g);
        c.setNomeCupom("Teste 1");
        c.setUsado(true);
        c.setDataExpiracao(LocalDate.now().plusDays(30));
        c.setCliente(cliente);
        c.setDesconto(20);

        Cupom c1 = new Cupom();
        c1.setGerente(g);
        c1.setNomeCupom("Teste 2");
        c1.setUsado(false);
        c1.setDataExpiracao(LocalDate.now().plusDays(15));
        c1.setCliente(cliente);
        c1.setDesconto(20);


        Cupom c2 = new Cupom();
        c2.setGerente(g);
        c2.setNomeCupom("Teste 3");
        c2.setUsado(false);
        c2.setDataExpiracao(LocalDate.now().minusDays(15));
        c2.setCliente(cliente);
        c2.setDesconto(20);
        List<Cupom> cupons = new ArrayList<>();
        cupons.add(c);
        cupons.add(c1);
        cupons.add(c2);
        cupomRepository.saveAll(cupons);
    }
}
