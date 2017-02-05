package tn.cni.dao;

import java.util.List;

import tn.cni.domain.Fe;

public interface FeDao {

    public void add(Fe fe);
	
	public Fe edit(Fe fe);
	
	public void delete(Long id);
	
	public List<Fe> findAll();
	
	public Fe findById(Long id);
}
