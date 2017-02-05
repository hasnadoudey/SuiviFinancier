package tn.cni.services.impl;

import java.util.List;

import tn.cni.dao.EtatPaiementDao;
import tn.cni.dao.EtatPaiementJpaDao;
import tn.cni.domain.EtatPaiement;
import tn.cni.services.EtatPaiementService;

public class EtatPaiementServiceImpl implements EtatPaiementService {
	
	EtatPaiementDao daoEtatPaiement = new EtatPaiementJpaDao();
	
	

	public EtatPaiementDao getDaoEtatPaiement() {
		return daoEtatPaiement;
	}

	public void setDaoEtatPaiement(EtatPaiementDao daoEtatPaiement) {
		this.daoEtatPaiement = daoEtatPaiement;
	}

	public List<EtatPaiement> findAll() {
		
		return daoEtatPaiement.findAll();
	}

	public void add(EtatPaiement etatPaiement) {
		daoEtatPaiement.add(etatPaiement);
		
	}

	public EtatPaiement edit(EtatPaiement etatPaiement) {
		
		return daoEtatPaiement.edit(etatPaiement);
	}

	public void delete(Long id) {
		daoEtatPaiement.delete(id);	
	}

	public EtatPaiement findById(Long id) {
		
		return daoEtatPaiement.findById(id);
	}


}
