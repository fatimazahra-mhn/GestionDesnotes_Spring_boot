package com.gsnotes.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gsnotes.bo.InscriptionMatiere;
import com.gsnotes.bo.Module;

public interface IModule extends JpaRepository<Module, Long> {
	
	@Query("select modules from Module modules where modules.niveau.idNiveau=:niv ORDER BY modules.code ,modules.titre ")
    public List<Module> getModulesByNiveau(@Param("niv") Long idNiveau);
}
