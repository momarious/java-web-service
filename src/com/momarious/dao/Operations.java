		package com.momarious.dao;

import java.sql.Connection;

import com.momarious.model.Classe;
import com.momarious.model.Etudiant;
import com.momarious.model.Evaluation;
import com.momarious.model.Matiere;

public interface Operations {
	
	public Connection getConnection() throws Exception;	
	public boolean existsUser(String email, String password) throws Exception; 
	
	/**
	 * si codeMat == -1 	: afficher les notes d'un étudiant sur une matière
	 * sinon 				: afficher les notes d'un étudiant
	*/ public Evaluation[] getArrayEvaluations(int codeEtud, int codeMat)  throws Exception;
	
	/**
	 * afficher la note d'un étudiant sur une matière
	*/ public Evaluation[] getEvaluations(int codeEtud, int codeMat)  throws Exception;
	
	
	/**
	 * La classe dont est associé un étudiant
	*/ public Classe getClasse(int codeEtud) throws Exception;

	
	/**
	 * Affiche un etudiant
	*/ public Etudiant getEtudiant(String nom, String prenom) throws Exception;

	
	/**
	 * Visualiser la liste des étudiants
	*/ //public Etudiant[] getArrayEtudiants()  throws Exception;
	public Etudiant[] getArrayEtudiantsByClasseName(int codeClasse)  throws Exception;
	
	
	/**
	 * Les informations sur une matiere
	*/ public Matiere getMatiere(int codeEtud, int codeMat)  throws Exception;
	
	
	/**
	 * La liste des matieres d'un etudiant 
	*/ public Matiere[] getArrayMatieres(int codeEtud) throws Exception;
	
}
