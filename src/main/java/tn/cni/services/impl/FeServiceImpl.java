package tn.cni.services.impl;

import java.util.List;

import tn.cni.dao.FeDao;
import tn.cni.dao.FeJpaDao;
import tn.cni.domain.Fe;
import tn.cni.services.FeService;

public class FeServiceImpl implements FeService{

	
FeDao dao = new FeJpaDao();
	
	public FeDao getDao() {
	return dao;
}

public void setDao(FeDao dao) {
	this.dao = dao;
}

	public List<Fe> findAll() {
		
		return dao.findAll();
	}

	public void add(Fe fe) {
		dao.add(fe);
		
	}

	public Fe edit(Fe fe) {
		
		return dao.edit(fe);
	}

	public void delete(Long id) {
		dao.delete(id);	
	}

	public Fe findById(Long id) {
		
		return dao.findById(id);
	}

	
}
