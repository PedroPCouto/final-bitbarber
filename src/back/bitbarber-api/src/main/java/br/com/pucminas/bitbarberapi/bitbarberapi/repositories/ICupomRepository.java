package br.com.pucminas.bitbarberapi.bitbarberapi.repositories;

import br.com.pucminas.bitbarberapi.bitbarberapi.models.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ICupomRepository extends JpaRepository<Cupom, Long> {

    @Query("SELECT c FROM Cupom c WHERE c.cliente.email = :email AND c.dataExpiracao >= :data_expiracao AND c.usado = false")
    List<Cupom> findAllValidNotExpiredCuponsByCustomer(@Param("email") String email, @Param("data_expiracao") LocalDate data_expiracao);

}
