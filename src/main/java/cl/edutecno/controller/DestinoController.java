package cl.edutecno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.edutecno.service.DestinoService;

@Controller
@RequestMapping("destinos")
public class DestinoController {
	
	@Autowired
	private DestinoService destinoService;
	
	@GetMapping
	public ModelAndView destinoLista() {
		ModelAndView modelAndView= new ModelAndView("destinos");
		modelAndView.addObject("destino", destinoService.findAll().getDestinos());
		return modelAndView;
		
	}

}
