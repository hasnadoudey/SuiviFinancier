package tn.cni.dao;

import java.util.List;


import tn.cni.domain.Ministere;

public interface MinistereDao {

	
    public void add(Ministere ministere);
	
	public Ministere edit(Ministere ministere);
	
	public void delete(Long id);
	
	public List<Ministere> findAll();
	
	public Ministere findById(Long id);
}
