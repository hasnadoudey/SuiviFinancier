package tn.cni.dao;

import java.util.List;

import tn.cni.domain.Facture;


public interface FactureDao {

    public void add(Facture facture);
	
	public Facture edit(Facture facture);
	
	public void delete(Long id);
	
	public List<Facture> findAll();
	
	public Facture findById(Long id);;

	
	
}
