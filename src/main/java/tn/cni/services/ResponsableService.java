package tn.cni.services;

import java.util.List;

import tn.cni.domain.Responsable;

public interface ResponsableService {
	
    public void add(Responsable responsable);
	
    public Responsable edit(Responsable responsable);
	
	public void delete(Integer id);
	
	public List<Responsable> findAll();
	
	public Responsable findById(Integer id);
	
	 

}
