package br.com.pucminas.bitbarberapi.bitbarberapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "barbeiro")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Barbeiro {
    @Id
    @Column(name = "email")
    private String email;
    @Column(name = "nome")
    private String nome;
    @Column(name = "senha")
    private String senha;
    @Column(name = "nota_media")
    private String notaMedia;
    @ManyToMany(targetEntity = Servico.class)
    private List<Servico> servicos;
    @OneToMany(targetEntity = ServicoAgenda.class)
    private List<ServicoAgenda> servicosAgendados;
    @Column(name = "profilPictureURL")
    private String profilPictureURL;

}
