package com.gsnotes.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gsnotes.bo.InscriptionAnnuelle;
import com.gsnotes.bo.Niveau;

public interface IInscriptionAnnuelleDao extends JpaRepository<InscriptionAnnuelle, Long> {
	
	
	//@Query("select ia from InscriptionAnnuelle ia where ia.niveau.idNiveau=:n")
    //public List<InscriptionAnnuelle> getInscriptionAnnuelleByNiveau(@Param("n") Long niv);
	public List<InscriptionAnnuelle> getInscriptionAnnuelleByNiveau(Niveau niveau);
	
	
	

}
