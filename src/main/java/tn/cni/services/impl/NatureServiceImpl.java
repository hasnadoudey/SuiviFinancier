package tn.cni.services.impl;

import java.util.List;


import tn.cni.dao.NatureDao;
import tn.cni.dao.NatureJpaDao;

import tn.cni.domain.Nature;
import tn.cni.services.NatureService;

public class NatureServiceImpl implements NatureService{


   NatureDao dao = new NatureJpaDao();
	
	public List<Nature> findAll() {
		
		return dao.findAll();
	}

	public NatureDao getDao() {
		return dao;
	}

	public void setDao(NatureDao dao) {
		this.dao = dao;
	}
	
	
}
