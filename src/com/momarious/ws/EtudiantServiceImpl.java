package com.momarious.ws;

import javax.jws.WebService;

import com.momarious.dao.OperationsImpl;
import com.momarious.model.Etudiant;
import com.momarious.model.Evaluation;
import com.momarious.model.Matiere;

@WebService(endpointInterface="com.momarious.ws.EtudiantService", serviceName="EtudiantService")
public class EtudiantServiceImpl implements EtudiantService {

	OperationsImpl dao = new OperationsImpl();
	
	@Override
	public Etudiant getEtudiantByName(String nom, String prenom) throws Exception  {
		return dao.getEtudiant(nom, prenom);
	}
	
	/**
	 * Les informations sur les matieres d'un etudiant
	 */
	@Override
	public Matiere[] getListMatieresByEtud(int codeEtud) throws Exception {
		return dao.getArrayMatieres(codeEtud);
	}
	
	/**
	 * Les informations sur tout les etudiants
	 */
	@Override
	public Etudiant[] getListEtudiants(int codeClasse) throws Exception {
		return dao.getArrayEtudiantsByClasseName(codeClasse);
	}
	
	/**
	 * Les informations sur tout les etudiants
	 */
	@Override
	public Evaluation[] getListEvaluationsByEtudAndMat(int codeMat, int codeEtud) throws Exception {
		return dao.getArrayEvaluations(codeEtud, codeMat);
	}
	
	@Override
	public boolean login(String email, String password) throws Exception {
		return dao.existsUser(email, password);
	}

	@Override
	public Matiere getMatiereByEtudAndMat(int codeEtud, int codeMat) throws Exception {
		return dao.getMatiere(codeEtud, codeMat);
	}
}

