package tn.cni.dao;

import java.util.List;

import tn.cni.domain.Composante;

public interface ComposanteDao {

    public void add(Composante composante);
	
	public Composante edit(Composante composante);
	
	public void delete(Long id);
	
	public List<Composante> findAll();
	
	public Composante findById(Long id);
}
