package br.com.pucminas.bitbarberapi.bitbarberapi.repositories;

import br.com.pucminas.bitbarberapi.bitbarberapi.models.Barbeiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IBarbeiroRepository extends JpaRepository<Barbeiro, String> {

    public Barbeiro getBarbeiroByEmail(@Param("email") String email);
}
