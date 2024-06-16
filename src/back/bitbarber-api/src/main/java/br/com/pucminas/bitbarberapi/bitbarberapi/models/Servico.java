package br.com.pucminas.bitbarberapi.bitbarberapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "servico")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Servico {

    @Id
    @Column(name = "codigo_servico")
    private long codigoServico;
    @Column(name = "nome")
    private String nome;
    @Column(name = "preco")
    private double preco;
    @ManyToMany(targetEntity = Barbeiro.class)
    private List<Barbeiro> barbeiros;
}
