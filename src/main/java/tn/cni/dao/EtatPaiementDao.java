package tn.cni.dao;

import java.util.List;

import tn.cni.domain.EtatPaiement;

public interface EtatPaiementDao {

	public void add(EtatPaiement etatPaiement);
	
	public List<EtatPaiement> findAll();
	
	public EtatPaiement edit(EtatPaiement etatPaiement);
		
	public void delete(Long id);
		
	public EtatPaiement findById(Long id);
}
