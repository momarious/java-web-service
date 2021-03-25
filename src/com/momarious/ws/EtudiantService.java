package com.momarious.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.momarious.model.Etudiant;
import com.momarious.model.Evaluation;
import com.momarious.model.Matiere;

@WebService(name = "EtudiantService")
@SOAPBinding(style = Style.RPC)
public interface EtudiantService {

	@WebMethod
	public boolean login(String email, String password) throws Exception;		
	
	@WebMethod
	public Etudiant[] getListEtudiants(int codeClasse) throws Exception;		
	
	@WebMethod
	public Etudiant getEtudiantByName(String nom, String prenom) throws Exception;	
	
	@WebMethod
	public Matiere[] getListMatieresByEtud(int codeEtud) throws Exception;
	
	@WebMethod
	public Matiere getMatiereByEtudAndMat(int codeEtud, int codeMat) throws Exception;
	
	@WebMethod
	public Evaluation[] getListEvaluationsByEtudAndMat(int codeMat, int codeEtud) throws Exception ;
		
}
