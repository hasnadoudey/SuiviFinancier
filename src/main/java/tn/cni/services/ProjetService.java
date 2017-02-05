package tn.cni.services;

import java.util.List;

import tn.cni.domain.Projet;




public interface ProjetService {

public List<Projet> findAll();
	
public void add(Projet projet);

public Projet edit(Projet projet);

public void delete(Long id);

public Projet findById(Long id);
}
