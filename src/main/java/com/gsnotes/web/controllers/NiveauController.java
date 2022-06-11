package com.gsnotes.web.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gsnotes.bo.Niveau;

import com.gsnotes.services.INiveauService;


@Controller
@RequestMapping("/prof")
public class NiveauController {
	
	
	@Autowired
	private INiveauService niveauService;
	 
	@RequestMapping(value = "haja" ,method = RequestMethod.GET)
	public String choose(
			Model model) {
		List<Niveau> niveaux =niveauService.getAllNiveau();
		model.addAttribute("NiveauList", niveaux);
		return "prof/choice";
			
	}
	
	

}
