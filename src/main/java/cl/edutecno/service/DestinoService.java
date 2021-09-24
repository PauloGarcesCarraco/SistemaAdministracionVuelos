package cl.edutecno.service;

import cl.edutecno.dto.DestinoDTO;
import cl.edutecno.model.Destino;

public interface DestinoService {
	DestinoDTO findAll();
	DestinoDTO add(Destino destino);

}
