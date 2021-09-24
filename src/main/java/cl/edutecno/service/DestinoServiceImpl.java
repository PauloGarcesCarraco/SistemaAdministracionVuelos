package cl.edutecno.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.edutecno.dto.DestinoDTO;
import cl.edutecno.model.Destino;
import cl.edutecno.repository.DestinoRepository;

@Service
public class DestinoServiceImpl implements DestinoService{
	private static final Logger log = LoggerFactory.getLogger(DestinoServiceImpl.class);

	@Autowired
	private DestinoRepository daoDestino;
	private DestinoDTO respuestaDestino;
	
	@Override
	@Transactional(readOnly = true)
	public DestinoDTO findAll() {
		respuestaDestino=new DestinoDTO(new ArrayList<Destino>(),"Ha ocurrido un error", "101");
		try {
			respuestaDestino.setDestinos((List<Destino>)daoDestino.findAll());
			respuestaDestino.setMensaje(String.format("Se ha/n encontrado %d registro/s", respuestaDestino.getDestinos().size()));
			respuestaDestino.setCodigo("0");
		} catch (Exception e) {
			log.trace("DestinoService: Error en findAll", e);
		}
		return respuestaDestino;
	}

	@Override
	@Transactional
	public DestinoDTO add(Destino destino) {
		respuestaDestino=new DestinoDTO(new ArrayList<Destino>(),"Ha ocurrido un error", "102");
		try {
			daoDestino.save(destino);
			respuestaDestino.setMensaje(String.format("Se ha guardado correctamente el destino %s", destino.getCiudad()+", "+destino.getPais()));
		} catch (Exception e) {
			log.trace("DestinoService: Error en add", e);
		}
		return respuestaDestino;
	}

}
