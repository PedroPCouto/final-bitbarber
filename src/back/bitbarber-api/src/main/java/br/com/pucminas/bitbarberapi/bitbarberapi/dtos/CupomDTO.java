package br.com.pucminas.bitbarberapi.bitbarberapi.dtos;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CupomDTO {

    Integer desconto;
    LocalDate dataCupom;
    List<String> selectedUsers;
    String nomeCupom;
}



