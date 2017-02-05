package tn.cni.services;

import java.util.List;

import tn.cni.domain.Compte;

public interface CompteService {

	
	
	  public void add(Compte compte);
		
		public Compte edit(Compte compte);
		
		public void delete(Long id);
		
		public List<Compte> findAll();
		
		public Compte findById(Long id);
}
