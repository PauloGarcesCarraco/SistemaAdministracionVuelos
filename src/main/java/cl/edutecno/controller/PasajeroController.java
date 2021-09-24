package cl.edutecno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.edutecno.service.PasajeroService;

@Controller
public class PasajeroController {
	
	@Autowired
	private PasajeroService pasajeroService;
	
	@GetMapping({"/","pasajeros"})
	public ModelAndView pasajeros() {
		ModelAndView modelAndView= new ModelAndView("pasajeros");
		modelAndView.addObject("pasajeros", pasajeroService.findAll().getPasajeros());
		return modelAndView;
		
	}

}
