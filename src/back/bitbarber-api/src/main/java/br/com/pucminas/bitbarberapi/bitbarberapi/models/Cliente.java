package br.com.pucminas.bitbarberapi.bitbarberapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "cliente")
public class Cliente {
    @Id
    @Column(name = "email")
    private String email;
    @Column(name = "nome")
    private String nome;
    @Column(name = "senha")
    private String senha;
    @Column(name = "data_aniversario")
    private LocalDate dataAniversario;
    @Column(name = "created_date")
    private LocalDate createdDate;

    @OneToMany(targetEntity = ServicoAgenda.class)
    private List<ServicoAgenda> servicoAgendaList;

    public Cliente(String email, String nome, String senha, LocalDate dataAniversario, LocalDate createdDate){
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.dataAniversario = dataAniversario;
        this.createdDate = createdDate;
    }
}
