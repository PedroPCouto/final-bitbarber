package br.com.pucminas.bitbarberapi.bitbarberapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Feedback")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_feedback")
    private Long idFeedback;
    @Column(name = "nota")
    private double nota;
    @Column(name = "comentario")
    private String comentario;
}
