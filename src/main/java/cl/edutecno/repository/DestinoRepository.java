package cl.edutecno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.edutecno.model.Destino;


@Repository
public interface DestinoRepository extends JpaRepository<Destino, Integer> {

}
