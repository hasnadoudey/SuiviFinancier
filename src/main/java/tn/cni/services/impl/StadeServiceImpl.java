package tn.cni.services.impl;

import java.util.List;

import tn.cni.dao.StadeDao;
import tn.cni.dao.StadeJpaDao;
import tn.cni.domain.Stade;
import tn.cni.services.StadeService;

public class StadeServiceImpl implements StadeService{

StadeDao dao = new StadeJpaDao();
	
	public List<Stade> findAll() {
		
		return dao.findAll();
	}

	public StadeDao getDao() {
		return dao;
	}

	public void setDao(StadeDao dao) {
		this.dao = dao;
	}

}
