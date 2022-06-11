package com.gsnotes.web.models;

public class NiveauModel {
	
	
	private Long id;
	private String alias;
	private Long idFiliere;
	private Long idNiveauSuivant;
	private String titre;

	public String getAlias() {
		return alias;
	}

	public NiveauModel(Long id, String alias, Long idFiliere, Long idNiveauSuivant, String titre) {
		super();
		this.id = id;
		this.alias = alias;
		this.idFiliere = idFiliere;
		this.idNiveauSuivant = idNiveauSuivant;
		this.titre = titre;
	}

	public Long getIdFiliere() {
		return idFiliere;
	}

	public void setIdFiliere(Long idFiliere) {
		this.idFiliere = idFiliere;
	}

	public Long getIdNiveauSuivant() {
		return idNiveauSuivant;
	}

	public void setIdNiveauSuivant(Long idNiveauSuivant) {
		this.idNiveauSuivant = idNiveauSuivant;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public NiveauModel(Long id, String alias) {
		super();
		this.id = id;
		this.alias = alias;
	}



	public void setAlias(String alias) {
		this.alias = alias;
	}

	public NiveauModel() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NiveauModel(Long id) {
		super();
		this.id = id;
	}
	

}
