package cl.edutecno.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import cl.edutecno.dto.DestinoDTO;
import cl.edutecno.model.Destino;
import cl.edutecno.service.DestinoService;
import cl.edutecno.service.PasajeroService;

@Controller
@RequestMapping("destinoNuevo")
public class NuevoDestinoController {
	private static final Logger log = LoggerFactory.getLogger(NuevoDestinoController.class);

	@Autowired
	private DestinoService destinoService;
	
	@Autowired
	private PasajeroService pasajeroService;
	
	@GetMapping
	public ModelAndView destinos(Model model) {
		ModelAndView modelAndView= new ModelAndView("destinoNuevo");
		modelAndView.addObject("destino", new Destino());
		model.addAttribute("pasajeros", pasajeroService.findAll().getPasajeros());
		return modelAndView;
	}
	
	@PostMapping("/agregar")
	public RedirectView agregar(@ModelAttribute Destino destino) {
		DestinoDTO respuestaServicio= destinoService.add(destino);
		if(respuestaServicio.getCodigo().equals("0")) {
			return new RedirectView("/destinoNuevo");
		}else {
			return new RedirectView("/destinos");
		}
	}
}
