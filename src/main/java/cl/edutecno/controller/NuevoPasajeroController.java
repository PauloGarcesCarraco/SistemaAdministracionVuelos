package cl.edutecno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import cl.edutecno.dto.PasajeroDTO;
import cl.edutecno.model.Pasajero;
import cl.edutecno.service.PasajeroService;

@Controller
@RequestMapping("pasajeroNuevo")
public class NuevoPasajeroController {
	
	@Autowired
	private PasajeroService pasajeroService;
	
	@GetMapping
	public ModelAndView pasajeros() {
		ModelAndView modelAndView= new ModelAndView("pasajeroNuevo");
		modelAndView.addObject("pasajero", new Pasajero());
		return modelAndView;
	}
	
	@PostMapping("/agregar")
	public RedirectView agregar(@ModelAttribute Pasajero pasajero) {
		PasajeroDTO respuestaServicio= pasajeroService.add(pasajero);
		if(respuestaServicio.getCodigo().equals("0")) {
			return new RedirectView("/pasajeros");
		}else {
			return new RedirectView("/pasajeroNuevo");
		}
	}

}
