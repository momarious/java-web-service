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
	 * si codeMat == -1 	: afficher les notes d'un �tudiant sur une mati�re
	 * sinon 				: afficher les notes d'un �tudiant
	*/ public Evaluation[] getArrayEvaluations(int codeEtud, int codeMat)  throws Exception;
	
	/**
	 * afficher la note d'un �tudiant sur une mati�re
	*/ public Evaluation[] getEvaluations(int codeEtud, int codeMat)  throws Exception;
	
	
	/**
	 * La classe dont est associ� un �tudiant
	*/ public Classe getClasse(int codeEtud) throws Exception;

	
	/**
	 * Affiche un etudiant
	*/ public Etudiant getEtudiant(String nom, String prenom) throws Exception;

	
	/**
	 * Visualiser la liste des �tudiants
	*/ //public Etudiant[] getArrayEtudiants()  throws Exception;
	public Etudiant[] getArrayEtudiantsByClasseName(int codeClasse)  throws Exception;
	
	
	/**
	 * Les informations sur une matiere
	*/ public Matiere getMatiere(int codeEtud, int codeMat)  throws Exception;
	
	
	/**
	 * La liste des matieres d'un etudiant 
	*/ public Matiere[] getArrayMatieres(int codeEtud) throws Exception;
	
}
