package com.momarious.model;

import java.util.Date;

public class Etudiant {
	
	public int codeEtudiant;
	public String nom;
	public String prenom;
	public Date dateDeNaissance;
	public Classe classe;
	
	public Etudiant() {}
	
	public int getCodeEtudiant() {
		return codeEtudiant;
	}
	
	public void setCodeEtudiant(int codeEtudiant) {
		this.codeEtudiant = codeEtudiant;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}
	
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe clas) {
		this.classe = clas;
	}

	@Override
	public String toString() {
		return "Etudiant [codeEtudiant=" + codeEtudiant + ", nom=" + nom + ", prenom=" + prenom + ", dateDeNaissance="
				+ dateDeNaissance + ", classe=" + classe + "]";
	}
	
	
}
