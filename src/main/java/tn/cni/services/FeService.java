package tn.cni.services;

import java.util.List;

import tn.cni.domain.Fe;

public interface FeService {
	   
	    public void add(Fe fe);
		
		public Fe edit(Fe fe);
		
		public void delete(Long id);
		
		public List<Fe> findAll();
		
		public Fe findById(Long id);
}
