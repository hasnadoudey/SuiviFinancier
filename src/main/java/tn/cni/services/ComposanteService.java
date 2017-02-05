package tn.cni.services;

import java.util.List;

import tn.cni.domain.Composante;

public interface ComposanteService {

	
	
	public void add(Composante composante);
	
	public Composante edit(Composante composante);
	
	public void delete(Long id);
	
	public List<Composante> findAll();
	
	public Composante findById(Long id);

}
