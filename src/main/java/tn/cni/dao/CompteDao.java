package tn.cni.dao;

import java.util.List;

import tn.cni.domain.Compte;

public interface CompteDao {

	
	
	    public void add(Compte compte);
		
		public Compte edit(Compte compte);
		
		public void delete(Long id);
		
		public List<Compte> findAll();
		
		public Compte findById(Long id);
}
