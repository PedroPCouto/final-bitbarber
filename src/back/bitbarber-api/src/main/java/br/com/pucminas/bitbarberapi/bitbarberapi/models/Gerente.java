package br.com.pucminas.bitbarberapi.bitbarberapi.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "gerente")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Gerente {
    @Id
    @Column(name = "email")
    private String email;
    @Column(name = "nome")
    private String nome;
    @Column(name = "senha")
    private String senha;
    @OneToMany(targetEntity = Cupom.class)
    private List<Cupom> cupons;

}
