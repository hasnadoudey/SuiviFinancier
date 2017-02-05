package tn.cni.services;

import java.util.List;

import tn.cni.domain.Operateur;

public interface OperateurService {
	
public void add(Operateur operateur);
	
	public Operateur edit(Operateur operateur);
	
	public void delete(Integer id);
	
	public List<Operateur> findAll();
	
	public Operateur findById(Integer id);
}
