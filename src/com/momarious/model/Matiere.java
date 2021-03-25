package com.momarious.model;

public class Matiere {

	private int codeMatiere;
	private String libelle;
	private String description;
	private Evaluation[] evaluations;
	
	public Matiere() {}
	
	public int getCodeMatiere() {
		return codeMatiere;
	}
	
	public void setCodeMatiere(int codeMatiere) {
		this.codeMatiere = codeMatiere;
	}
	
	public String getLibelle() {
		return libelle;
	}
	
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public Evaluation[] getEvaluations() {
		return evaluations;
	}	
	
	public void setEvaluations(Evaluation[] evaluations) {
		this.evaluations = evaluations;
	}	
	
	public float getMoyenne() {
		float noteDevoir = 0;
		float noteExam = 0;
		for (Evaluation e: evaluations) {
			if(e != null) {		
				if(e.getType().equals("Devoir"))
			    	noteDevoir = e.getNote(); 
			    if(e.getType().equals("Exam"))
			    	noteExam = e.getNote(); 
			}
	    }
		return (float) (noteDevoir * 0.4 + noteExam * 0.6);
	}
	
	public float getDevoir() {
		float noteDevoir = 0;
		for (Evaluation e: evaluations) {		
			if(e != null && e.getType().equals("Devoir")) 
				noteDevoir = e.getNote(); 
		}
		return noteDevoir;
	}
	
	public float getExam() {
		float noteExam = 0;
		for (Evaluation e: evaluations) {
			if(e != null && e.getType().equals("Exam")) 
				noteExam = e.getNote(); 
		}
		return noteExam;
	}

	@Override
	public String toString() {
		return "Matiere [codeMatiere=" + codeMatiere + ", libelle=" + libelle + ", description=" + description
				+ ", evaluations=" + evaluations + "]";
	}
	
	
}