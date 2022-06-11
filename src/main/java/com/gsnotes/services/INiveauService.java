package com.gsnotes.services;

import java.util.List;

import com.gsnotes.bo.Niveau;

public interface INiveauService {
	

	public List<Niveau> getAllNiveau();


	public Niveau getNiveauById(Long id);
	
	public Niveau getNiveauByAlias(String alias);

}
