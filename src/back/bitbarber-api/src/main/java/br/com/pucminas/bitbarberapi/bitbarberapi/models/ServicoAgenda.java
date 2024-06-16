package br.com.pucminas.bitbarberapi.bitbarberapi.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "servicoAgenda")
public class ServicoAgenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_servico_agendado")
    private Long codigoServicoAgendado;
    @Column(name = "dataMarcada")
    private LocalDate dataMarcada;
    @Column(name = "hora")
    private int hora;
    @Column(name = "created_date")
    private LocalDate created_date;
    @ManyToOne(targetEntity = Servico.class)
    private Servico servico;
    @ManyToOne(targetEntity = Cliente.class)
    private Cliente cliente;
    @ManyToOne(targetEntity = Barbeiro.class)
    private Barbeiro barbeiro;
    @OneToOne(targetEntity = Feedback.class)
    private Feedback feedback;
    @OneToOne(targetEntity = Cupom.class)
    private Cupom cupom;
}
