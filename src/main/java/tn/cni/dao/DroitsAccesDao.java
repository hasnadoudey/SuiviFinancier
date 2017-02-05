package tn.cni.dao;

import java.util.List;

import tn.cni.domain.DroitsAcces;



public interface DroitsAccesDao {
	
    public void add(DroitsAcces droitsAcces);
	
	public DroitsAcces edit(DroitsAcces droitsAcces);
	

	
	public List<DroitsAcces> findAll();
	


}
