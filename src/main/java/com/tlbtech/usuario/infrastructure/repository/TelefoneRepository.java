package main.java.com.tlbtech.usuario.infrastructure.repository;

import com.taciano.aprendendoprogramarspring.infrastructure.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone,Long> {
}
