package com.momarious.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.momarious.model.Classe;
import com.momarious.model.Etudiant;
import com.momarious.model.Evaluation;
import com.momarious.model.Matiere;

public class OperationsImpl implements Operations {

	private Connection db;
    
	@Override
    public Connection getConnection()  throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            db = DriverManager.getConnection("jdbc:mysql://localhost:3306/nom_de_la_base_de_donnees","root","");
            return db;    
        } catch(SQLException | ClassNotFoundException e) {
        	e.printStackTrace();
        }
        return null;
    }
	        
	@Override
    public Matiere[] getArrayMatieres(int codeEtud) throws Exception {
		PreparedStatement statement = null;
    	Matiere mat = null;
    	Matiere[] arrayMat = new Matiere[20];
    	int i = 0;
    	String query = "SELECT * FROM matiere WHERE codeMatiere IN ( SELECT codeMatiere FROM Evaluation WHERE codeEtudiant = '" + codeEtud + "' )" ;                    
        try {
           getConnection();
           statement = db.prepareStatement(query);
           ResultSet result = statement.executeQuery();  
           while (result.next()) {
        	   if(result != null) {  		   
	        	   mat = new Matiere();
	        	   mat.setCodeMatiere(result.getInt("codeMatiere"));
	        	   mat.setDescription(result.getString("description"));
	        	   mat.setLibelle(result.getString("libelle"));
				   mat.setEvaluations(this.getEvaluations(codeEtud, result.getInt("codeMatiere")));
				   System.out.println("natieres:	"+ mat);
	        	   arrayMat[i] = mat;
	          	   i++;
        	   }}
    	} catch(SQLException e) {
    		e.printStackTrace();   
    	} finally {
    		statement.close();
			db.close();
    	}
    	return arrayMat;
    }
	
	@Override
    public Etudiant getEtudiant(String nom, String prenom) throws Exception {
		PreparedStatement statement = null;
        Etudiant etud = new Etudiant();
        try {   
            getConnection();
            String query = "SELECT * FROM etudiant WHERE nom  = '" + nom + "' AND prenom = '" + prenom + "' ";                    
            statement = db.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                etud.setCodeEtudiant(result.getInt("codeEtudiant"));
            	etud.setNom(result.getString("nom"));
            	etud.setPrenom(result.getString("prenom"));
            	etud.setDateDeNaissance(result.getDate("dateDeNaissance"));
            	etud.setClasse(this.getClasse(result.getInt("codeEtudiant")));
            	return etud;
            }
            return null;         
        } catch(SQLException e) {
    		e.printStackTrace();
        } finally {
            statement.close();
            db.close();
        }
        return null;
    }
	
	@Override
    public Classe getClasse(int codeEtud) throws Exception {
		PreparedStatement statement = null;
        Classe clas = new Classe();
        try {   
            getConnection();
            String query = "SELECT * FROM classe WHERE codeClasse IN (SELECT codeClasse FROM etudiant WHERE codeEtudiant = '" + codeEtud + "')";                    
            statement = db.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                clas.setCodeClasse(result.getInt("codeClasse"));
                clas.setNom(result.getString("nom"));
                clas.setNiveau(result.getString("niveau"));
            	return clas;
            }
            return null;         
        } catch(SQLException e) {
    		e.printStackTrace();
        } finally {
            statement.close();
            db.close();
        }
        return null;
    }
	
	@Override
	public Evaluation[] getArrayEvaluations(int codeEtud, int codeMat)  throws Exception {
		PreparedStatement statement = null;
		Evaluation eval = null;
		Evaluation[] arrayEval = new Evaluation[100];
		String query = "SELECT * FROM evaluation WHERE codeEtudiant = '" + codeEtud + "' ";
		if(codeMat != -1)
		query = "SELECT * FROM evaluation WHERE codeEtudiant = '" + codeEtud + "' AND codeMatiere = '" + codeMat+ "' ";
		int i = 0;
		try {
    		getConnection();
    		statement = db.prepareStatement(query);
    		ResultSet result = statement.executeQuery();  
    		while(result.next()) {
    			if(result != null) {
	    			eval = new Evaluation();
	    			eval.setCodeMatiere(codeMat);
	    			eval.setCodeEtudiant(codeEtud);
	    			eval.setNote(result.getInt("note"));
	    			eval.setType(result.getString("type"));
	    			eval.setDateEvaluation(result.getDate("dateEvaluation"));
	    			arrayEval[i] = eval;
	    			i++;
			}}
        } catch(SQLException e) {
        	e.printStackTrace();   
    	} finally {
    		statement.close();
			db.close();
    	}
    	return arrayEval;
   }
	
		@Override
		public Evaluation[] getEvaluations(int codeEtud, int codeMat)  throws Exception {
			PreparedStatement statement = null;
			Evaluation[] arrayEval = new Evaluation[2];
			Evaluation eval = null;
			String query = "SELECT * FROM evaluation WHERE codeEtudiant = '" + codeEtud + "' AND codeMatiere = '" + codeMat + "' ";
			int i = 0;
			try {
	    		getConnection();
	    		statement = db.prepareStatement(query);
	    		ResultSet result = statement.executeQuery();  
	    		while(result.next()) {
	    			if(result != null) {
		    			eval = new Evaluation();
		    			eval.setCodeMatiere(codeMat);
		    			eval.setCodeEtudiant(codeEtud);
		    			eval.setNote(result.getInt("note"));
		    			eval.setType(result.getString("type"));
		    			eval.setDateEvaluation(result.getDate("dateEvaluation"));
		            	arrayEval[i] = eval;
		            	i++;
		    	}}
	        } catch(SQLException e) {
	        	e.printStackTrace();   
	    	} finally {
	    		statement.close();
				db.close();
	    	}
	    	return arrayEval;
	   }

	@Override
	public Etudiant[] getArrayEtudiantsByClasseName(int codeClasse) throws Exception {
		PreparedStatement statement = null;
		Etudiant etud = null;
		Etudiant[] arrayEtud = new Etudiant[100];
    	int i = 0;
        try {   
            getConnection();
            statement = db.prepareStatement("SELECT * FROM etudiant  WHERE codeClasse = '" + codeClasse + "' ");
            ResultSet result = statement.executeQuery();
            while(result.next()) {
            	if(result != null) {
            	etud = new Etudiant();
            	etud.setCodeEtudiant(result.getInt("codeEtudiant"));
            	etud.setNom(result.getString("nom"));
            	etud.setPrenom(result.getString("prenom"));
            	etud.setDateDeNaissance(result.getDate("dateDeNaissance"));
            	etud.setClasse(this.getClasse(result.getInt("codeEtudiant")));
            	arrayEtud[i] = etud;
    			i++;
            	}
			}
            return arrayEtud;         
        } catch(SQLException e) {
    		e.printStackTrace();
        } finally {
            statement.close();
            db.close();
        }
        return null;
	}


	@Override
	public Matiere getMatiere(int codeEtud, int codeMat) throws Exception {
		PreparedStatement statement = null;
		Matiere mat = null;
		try {   
            getConnection();
            String query = "SELECT * FROM matiere WHERE codeMatiere = '" + codeMat + "' AND codeMatiere IN "
            		+ "(SELECT codeMatiere FROM evaluation WHERE codeEtudiant = '" + codeEtud + "' )" ;                    
    		statement = db.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
            	mat = new Matiere();
            	mat.setCodeMatiere(result.getInt("codeMatiere"));
            	mat.setLibelle(result.getString("libelle"));
            	mat.setDescription(result.getString("description"));
            	mat.setEvaluations(this.getArrayEvaluations(codeEtud, codeMat));
            	return mat;
			}
            return null;         
        } catch(SQLException e) {
    		e.printStackTrace();
        } finally {
            statement.close();
            db.close();
        }
        return null;
	}

	@Override
	public boolean existsUser(String email, String password) throws Exception {
		PreparedStatement statement = null;
    	try {
           getConnection();
           String query = "SELECT * FROM administrateur WHERE adresseEmail = '" + email +  "' AND  motDePass = '" + password +  "' " ;                        ;   
           statement = db.prepareStatement(query);
           ResultSet result = statement.executeQuery();  
           return result.next();
           
    	} catch(SQLException e) {
    		e.printStackTrace();   
    	} finally {
    		statement.close();
			db.close();
    	}
    	return false;
	}
	
}
