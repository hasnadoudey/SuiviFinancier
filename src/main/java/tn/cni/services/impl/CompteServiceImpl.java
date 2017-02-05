package tn.cni.services.impl;

import java.util.List;

import tn.cni.dao.CompteDao;
import tn.cni.dao.CompteJpaDao;
import tn.cni.domain.Compte;
import tn.cni.services.CompteService;

public class CompteServiceImpl implements CompteService{

	
	CompteDao dao = new CompteJpaDao();
	

	public List<Compte> findAll() {
		
		return dao.findAll();
	}

	public void add(Compte compte) {
		dao.add(compte);
		
	}

	public Compte edit(Compte compte) {
		
		return dao.edit(compte);
	}

	public void delete(Long id) {
		dao.delete(id);	
	}

	public Compte findById(Long id) {
		
		return dao.findById(id);
	}

	public CompteDao getDao() {
		return dao;
	}

	public void setDao(CompteDao dao) {
		this.dao = dao;
	}

}
