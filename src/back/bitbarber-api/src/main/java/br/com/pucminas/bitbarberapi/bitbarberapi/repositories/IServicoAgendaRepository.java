package br.com.pucminas.bitbarberapi.bitbarberapi.repositories;

import br.com.pucminas.bitbarberapi.bitbarberapi.models.Cliente;
import br.com.pucminas.bitbarberapi.bitbarberapi.models.ServicoAgenda;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IServicoAgendaRepository extends JpaRepository<ServicoAgenda, Long> {
    List<ServicoAgenda> getAllByBarbeiroEmailAndDataMarcada(@Param("email") String email, @Param("dataMarcada")LocalDate dataMarcada);

    List<ServicoAgenda> getAllByClienteEmailAndDataMarcadaLessThan(@Param("email") String email, @Param("dataMarcada")LocalDate dataMarcada);
    List<ServicoAgenda> getAllByClienteEmailAndDataMarcadaIsGreaterThan(@Param("email") String email, @Param("dataMarcada")LocalDate dataMarcada);

}
