package com.gsnotes.services.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsnotes.bo.Compte;
import com.gsnotes.bo.InscriptionAnnuelle;
import com.gsnotes.bo.Niveau;
import com.gsnotes.dao.IInscriptionAnnuelleDao;
import com.gsnotes.dao.INiveauDao;
import com.gsnotes.services.IInscriptionAnnuelleService;
import com.gsnotes.utils.export.ExcelExporter;

@Service
@Transactional

public class InscriptionAnnuelleServiceImpl implements IInscriptionAnnuelleService {
	
	
	@Autowired
	private IInscriptionAnnuelleDao inscAnn;
	
	@Autowired 
	private INiveauDao niveauDao;

	@Override
	public List<InscriptionAnnuelle> getAllInscriptionByIdNiveau(Long id) {
		Niveau niveau =niveauDao.getById(id);
		return inscAnn.getInscriptionAnnuelleByNiveau(niveau);
	}
	
	@Override
	public ExcelExporter prepareInscriptionExport(List<InscriptionAnnuelle> inscriptions) {
		String[] columnNames = new String[] { "Type Inscription", "Nom & Prenom", "CNE","Niveau" };
		String[][] data = new String[inscriptions.size()][4];

		int i = 0;
		for (InscriptionAnnuelle ins : inscriptions) {
			data[i][0] = ins.getType();
			data[i][1] = ins.getEtudiant().getNom()+" "+ins.getEtudiant().getPrenom();
			data[i][2]=ins.getEtudiant().getCne();
			data[i][3] = ins.getNiveau().getAlias();
			i++;
		}

		return new ExcelExporter(columnNames, data, "inscriptions");

	}

}

