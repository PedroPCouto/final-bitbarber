package br.com.pucminas.bitbarberapi.bitbarberapi.repositories;

import br.com.pucminas.bitbarberapi.bitbarberapi.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, String> {
    Cliente findClienteByEmailAndSenha(@Param("email") String email, @Param("senha") String senha);

    Cliente findClienteByEmail(@Param("email") String email);

    @Query("SELECT c FROM Cliente c WHERE EXISTS (" +
            "SELECT sa FROM ServicoAgenda sa " +
            "WHERE sa.cliente = c " +
            "AND sa.dataMarcada = (" +
            "    SELECT MAX(sa2.dataMarcada) FROM ServicoAgenda sa2 " +
            "    WHERE sa2.cliente = c" +
            ") " +
            "AND sa.dataMarcada BETWEEN :startDate AND :endDate" +
            ")")
    List<Cliente> findClientesWithRecentServicoAgenda(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
