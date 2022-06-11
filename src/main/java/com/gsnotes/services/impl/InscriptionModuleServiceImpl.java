package com.gsnotes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gsnotes.bo.Element;
import com.gsnotes.bo.InscriptionAnnuelle;
import com.gsnotes.bo.InscriptionModule;
import com.gsnotes.dao.IInscriptionAnnuelleDao;
import com.gsnotes.dao.InsciptionModuleDao;
import com.gsnotes.services.IInscriptionModuleService;
import com.gsnotes.utils.export.ExcelExporter;

public class InscriptionModuleServiceImpl implements IInscriptionModuleService {
	
	
	
	
	@Autowired
	private InsciptionModuleDao inscMod;

	@Override
	public InscriptionModule getAllInscriptionByModuleEtInscription(Long id1,Long id2) {
		return inscMod.noteOfEtdutiant(id1, id2) ;
	}

	@Override
	public ExcelExporter prepareInscriptionModuleExport(List<InscriptionModule> inscriptions) {
		
		String[] columnNames = new String[] { "Nom & Prenom", "CNE","Niveau","Modules","Notes","Validation" };
		String[][] data = new String[inscriptions.size()][6];

		int i = 0;
		for (InscriptionModule ins : inscriptions) {
			data[i][0] = ins.getInscriptionAnnuelle().getEtudiant().getNom()+" "+ins.getInscriptionAnnuelle().getEtudiant().getPrenom();
			data[i][1] = ins.getInscriptionAnnuelle().getEtudiant().getCne();
			data[i][2]=ins.getInscriptionAnnuelle().getNiveau().getAlias();
			List<Element> modules =ins.getModule().getElements();
			//data[i][3] = ins.getModule();
			i++;
		}

		return new ExcelExporter(columnNames, data, "inscriptions");
	}

}
//@Autowired
//private IInscriptionAnnuelleDao inscAnn;
//
//@Override
//public List<InscriptionAnnuelle> getAllInscriptionByIdNiveau(Long id) {
//	return inscAnn.getInscriptionAnnuelleByNiveau(id);
//}
//
//@Override
//public ExcelExporter prepareInscriptionExport(List<InscriptionAnnuelle> inscriptions) {
//	String[] columnNames = new String[] { "Type Inscription", "Nom & Prenom", "CNE","Niveau" };
//	String[][] data = new String[inscriptions.size()][4];
//
//	int i = 0;
//	for (InscriptionAnnuelle ins : inscriptions) {
//		data[i][0] = ins.getType();
//		data[i][1] = ins.getEtudiant().getNom()+" "+ins.getEtudiant().getPrenom();
//		data[i][2]=ins.getEtudiant().getCne();
//		data[i][3] = ins.getNiveau().getAlias();
//		i++;
//	}
//
//	return new ExcelExporter(columnNames, data, "inscriptions");
//
//}
