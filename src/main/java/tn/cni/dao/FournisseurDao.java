package tn.cni.dao;

import java.util.List;

import tn.cni.domain.Fournisseur;

public interface FournisseurDao {

    public void add(Fournisseur fournisseur);
	
	public Fournisseur edit(Fournisseur fournisseur);
	
	public void delete(Long id);
	
	public List<Fournisseur> findAll();
	
	public Fournisseur findById(Long id);
}
