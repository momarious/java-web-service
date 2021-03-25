package com.momarious.model;

public class Classe {
	
	private int codeClasse;
	private String nom;
	private String niveau;
	
	public Classe() {}
	
	public int getCodeClasse() {
		return codeClasse;
	}

	public void setCodeClasse(int codeClasse) {
		this.codeClasse = codeClasse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	@Override
	public String toString() {
		return "Classe [codeClasse=" + codeClasse + ", nom=" + nom + ", niveau=" + niveau + "]";
	}
}
