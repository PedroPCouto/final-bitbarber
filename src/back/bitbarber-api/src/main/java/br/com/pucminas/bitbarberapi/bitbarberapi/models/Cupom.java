package br.com.pucminas.bitbarberapi.bitbarberapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "Cupom")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Cupom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_cupom")
    private long codigoCupom;
    @Column(name = "desconto")
    private double desconto;
    @Column(name = "data_expiracao")
    private LocalDate dataExpiracao;
    @Column(name = "nome_cupom")
    private String nomeCupom;
    @Column(name = "usado")
    private Boolean usado;

    @ManyToOne(targetEntity = Gerente.class)
    private Gerente gerente;
    @ManyToOne(targetEntity = Cliente.class)
    private Cliente cliente;
}
