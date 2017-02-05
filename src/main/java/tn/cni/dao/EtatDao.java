package tn.cni.dao;

import java.util.List;

import tn.cni.domain.Etat;

public interface EtatDao {

	
    public void add(Etat etat);
	
	public Etat edit(Etat etat);
	
	public void delete(Integer id);
	
	public List<Etat> findAll();
	
	public Etat findById(Integer id);
}
