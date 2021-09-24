package cl.edutecno.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.edutecno.dto.PasajeroDTO;
import cl.edutecno.model.Pasajero;
import cl.edutecno.repository.PasajeroRepository;

@Service
public class PasajeroServiceImpl implements PasajeroService{
	private static final Logger log = LoggerFactory.getLogger(PasajeroServiceImpl.class);

	@Autowired
	private PasajeroRepository daoPasajero;
	private PasajeroDTO respuestaPasajero;
	
	@Override
	@Transactional(readOnly = true)
	public PasajeroDTO findAll() {
		respuestaPasajero=new PasajeroDTO(new ArrayList<Pasajero>(),"Ha ocurrido un error", "101");
		try {
			respuestaPasajero.setPasajeros((List<Pasajero>)daoPasajero.findAll());
			respuestaPasajero.setMensaje(String.format("Se ha/n encontrado %d registro/s", respuestaPasajero.getPasajeros().size()));
			respuestaPasajero.setCodigo("0");
		} catch (Exception e) {
			log.trace("PasajeroService: Error en findAll", e);
		}
		return respuestaPasajero;
	}

	@Override
	@Transactional
	public PasajeroDTO add(Pasajero pasajero) {
		respuestaPasajero=new PasajeroDTO(new ArrayList<Pasajero>(),"Ha ocurrido un error", "102");
		try {
			daoPasajero.save(pasajero);
			respuestaPasajero.setMensaje(String.format("Se ha guardado correctamente el pasajero %s", pasajero.getNombre()+" "+pasajero.getApellido()));
			respuestaPasajero.setCodigo("0");
			
		} catch (Exception e) {
			log.trace("PasajeroService: error en add()",e);
		}
		
		return respuestaPasajero;
	}

}
