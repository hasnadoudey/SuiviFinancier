package tn.cni.dao;



import java.util.List;

import tn.cni.domain.Projet;


public interface ProjetDao {
	
	public void add(Projet projet);
	
	public Projet edit(Projet projet);
	
	public void delete(Long id);
	
	public List<Projet> findAll();
	
	public Projet findById(Long id);
	
	
}
