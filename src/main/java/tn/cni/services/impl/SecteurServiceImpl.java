package tn.cni.services.impl;

import java.util.List;

import tn.cni.dao.SecteurDao;
import tn.cni.dao.SecteurJpaDao;
import tn.cni.domain.Secteur;
import tn.cni.services.SecteurService;

public class SecteurServiceImpl implements SecteurService {

	SecteurDao dao = new SecteurJpaDao();
	public List<Secteur> findAll() {
		
		return dao.findAll();
	}
	public SecteurDao getDao() {
		return dao;
	}
	public void setDao(SecteurDao dao) {
		this.dao = dao;
	}
	
}
