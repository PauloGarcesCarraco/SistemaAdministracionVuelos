package cl.edutecno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.edutecno.model.Pasajero;

@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero, Integer> {

}
