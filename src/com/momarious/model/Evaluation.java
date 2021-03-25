package com.momarious.model;

import java.util.Date;

public class Evaluation {

	private float note;
	private String type;
	private int codeEtudiant;
	private int codeMatiere;
	private Date dateEvaluation;

	public Evaluation() {}

	public float getNote() {
		return note;
	}
	

	public void setNote(float note) {
		this.note = note;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCodeEtudiant() {
		return codeEtudiant;
	}

	public void setCodeEtudiant(int codeEtudiant) {
		this.codeEtudiant = codeEtudiant;
	}

	public int getCodeMatiere() {
		return codeMatiere;
	}

	public void setCodeMatiere(int codeMatiere) {
		this.codeMatiere = codeMatiere;
	}

	public Date getDateEvaluation() {
		return dateEvaluation;
	}

	public void setDateEvaluation(Date dateEvaluation) {
		this.dateEvaluation = dateEvaluation;
	}

	@Override
	public String toString() {
		return "Evaluation [note=" + note + ", type=" + type + ", codeEtudiant="
				+ codeEtudiant + ", codeMatiere=" + codeMatiere + ", dateEvaluation=" + dateEvaluation + "]";
	}
	
	
}
