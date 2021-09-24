package cl.edutecno.service;

import cl.edutecno.dto.PasajeroDTO;
import cl.edutecno.model.Pasajero;

public interface PasajeroService {
	PasajeroDTO findAll();
	PasajeroDTO add(Pasajero pasajero);

}
