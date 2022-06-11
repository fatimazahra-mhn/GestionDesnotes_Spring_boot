package com.gsnotes.web.controllers;

import java.io.IOException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gsnotes.bo.Compte;
import com.gsnotes.bo.InscriptionAnnuelle;
import com.gsnotes.bo.Niveau;
import com.gsnotes.bo.Module;
import com.gsnotes.dao.IModule;
import com.gsnotes.services.IInscriptionAnnuelleService;
import com.gsnotes.services.IModuleService;
import com.gsnotes.utils.export.ExcelExporter;
import com.gsnotes.utils.export.notesEtudiantExporter;

@Controller
@RequestMapping("/prof")
public class ExportationController {
	
	
	@Autowired
	IInscriptionAnnuelleService inscService;
	
	@Autowired
	IModuleService module;
	
	
	@GetMapping(value = "Export1" )
	public void exportToExcel(HttpServletResponse response, HttpServletRequest request ) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		
		request.getParameter("niveau");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Inscriptions_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);
		
		String niv =request.getParameter("niveau");
		Long idNiveau= Long.valueOf(niv);

		List<InscriptionAnnuelle> inscriptions = inscService.getAllInscriptionByIdNiveau(idNiveau);
		for (InscriptionAnnuelle ins : inscriptions) {
			System.out.print(ins.getType() );
		}
		//List<InscriptionAnnuelle> inscriptions = inscService.getAllInscriptionByIdNiveau((long) 1);
		//List<Module> modules =module.getAllModuleByIdNiveau(idNiveau);
		List<Module> modules =module.getAllModuleByIdNiveau((long) 1);

		//ExcelExporter excelNotesExporter = inscService.prepareInscriptionExport(inscriptions);
		ExcelExporter excelNotesExporter = inscService.prepareInscriptionExport(inscriptions);
		
		
		
		excelNotesExporter.export(response);
	}

	
	
//	@RequestMapping(value = "Export/{idNiveau}" ,method = RequestMethod.GET)
//	public String Exporter( @PathVariable int idNiveau,Model model) {
//		
//		//Long idNiveau =request.getParameter("niveau");
//		
//		List<InscriptionAnnuelle> inscriptionsAnn=inscService.getAllInscriptionByIdNiveau(Long.valueOf(idNiveau));
//		//List<Module> modules =module.getAllModuleByIdNiveau(Long.valueOf(idNiveau));
//		
//		System.out.print(inscriptionsAnn);
//		//System.out.print(modules);
//		return "Export";
//		
//		
//		
//		//Long idNiveau =request.getParameter("niveau");
//	}
//		//model.addAttribute("NiveauList", niveaux);
//		//return "prof/choice";
//	
//	
//	
//	
//	
//	
//	

}
