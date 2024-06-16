package br.com.pucminas.bitbarberapi.bitbarberapi.repositories;

import br.com.pucminas.bitbarberapi.bitbarberapi.models.Cliente;
import br.com.pucminas.bitbarberapi.bitbarberapi.models.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IGerenteRepository extends JpaRepository<Gerente, String> {
    Gerente findClienteByEmailAndSenha(@Param("email") String email, @Param("senha") String senha);
}
