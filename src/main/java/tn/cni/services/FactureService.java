package tn.cni.services;

import java.util.List;

import tn.cni.domain.Facture;



/**
 * 
 * @author hasna
 *
 */
public interface FactureService {

public void add(Facture facture);
	
	public Facture edit(Facture facture);
	
	public void delete(Long id);
	
	public List<Facture> findAll();
	
	public Facture findById(Long id);;
		
}
