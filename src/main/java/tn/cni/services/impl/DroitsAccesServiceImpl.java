package tn.cni.services.impl;

import java.util.List;


import tn.cni.dao.DroitsAccesDao;
import tn.cni.dao.DroitsAccesJpaDao;
import tn.cni.domain.DroitsAcces;
import tn.cni.services.DroitsAccesService;

public class DroitsAccesServiceImpl implements DroitsAccesService{
DroitsAccesDao dao = new DroitsAccesJpaDao();
	
	public List<DroitsAcces> findAll() {
		
		return dao.findAll();
	}

	public void add(DroitsAcces droitsAcces) {
		dao.add(droitsAcces);
		
	}

	public DroitsAcces edit(DroitsAcces droitsAcces) {
		
		return dao.edit(droitsAcces);
	}


	public DroitsAccesDao getDao() {
		return dao;
	}

	public void setDao(DroitsAccesDao dao) {
		this.dao = dao;
	}

	
}
