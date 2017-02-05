package tn.cni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class HomeController {

	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index(){
		
		return "index";
	}
	
	
	
	@RequestMapping(value="/chefProjet/chefProjet",method=RequestMethod.GET)
	public String chefProjet(){
		return "chefProjet";
	}
	@RequestMapping(value="/responsableFinancier/responsableFinancier",method=RequestMethod.GET)
	public String responsableFinancier(){
		return "responsableFinancier";
	}
	@RequestMapping(value="/responsableMarche/responsableMarche",method=RequestMethod.GET)
	public String responsableMarche(){
		return "responsableMarche";
	}
	
	
	     
}
