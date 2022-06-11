package com.gsnotes.services;

import java.util.List;

import com.gsnotes.bo.Compte;
import com.gsnotes.bo.InscriptionAnnuelle;

import com.gsnotes.utils.export.ExcelExporter;
import com.gsnotes.utils.export.notesEtudiantExporter;


public interface IInscriptionAnnuelleService {
	
	
	public List<InscriptionAnnuelle> getAllInscriptionByIdNiveau(Long id);

	ExcelExporter prepareInscriptionExport(List<InscriptionAnnuelle> inscriptions);


}
