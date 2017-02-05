package tn.cni.services;

import java.util.List;

import tn.cni.domain.DroitsAcces;



public interface DroitsAccesService {

    public void add(DroitsAcces droitsAcces);
	
	public DroitsAcces edit(DroitsAcces droitsAcces);
	
	
	
	public List<DroitsAcces> findAll();

}
