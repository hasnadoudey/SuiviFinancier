package tn.cni.services.impl;

import java.util.List;

import tn.cni.dao.ComposanteDao;
import tn.cni.dao.ComposanteJpaDao;
import tn.cni.domain.Composante;
import tn.cni.services.ComposanteService;

public class ComposanteServiceImpl implements ComposanteService {

	
ComposanteDao dao = new ComposanteJpaDao();
	
	public List<Composante> findAll() {
		
		return dao.findAll();
	}

	public void add(Composante composante) {
		dao.add(composante);
		
	}

	public Composante edit(Composante composante) {
		
		return dao.edit(composante);
	}

	public void delete(Long id) {
		dao.delete(id);	
	}

	public Composante findById(Long id) {
		
		return dao.findById(id);
	}

	public ComposanteDao getDao() {
		return dao;
	}

	public void setDao(ComposanteDao dao) {
		this.dao = dao;
	}

	
}
