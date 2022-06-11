package com.gsnotes.services;

import java.util.List;


import com.gsnotes.bo.InscriptionModule;
import com.gsnotes.utils.export.ExcelExporter;

public interface IInscriptionModuleService {
	public InscriptionModule getAllInscriptionByModuleEtInscription(Long id1,Long id2);

	ExcelExporter prepareInscriptionModuleExport(List<InscriptionModule> inscriptions);

}
