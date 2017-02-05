package tn.cni.services.impl;

import java.util.List;

import tn.cni.dao.MinistereDao;
import tn.cni.dao.MinistereJpaDao;
import tn.cni.domain.Ministere;
import tn.cni.services.MinistereService;

public class MinistereServiceImpl implements MinistereService{
	
	MinistereDao dao = new MinistereJpaDao();
	
	public List<Ministere> findAll() {
		
		return dao.findAll();
	}

	public void add(Ministere ministere) {
		dao.add(ministere);
		
	}

	public Ministere edit(Ministere ministere) {
		
		return dao.edit(ministere);
	}

	public void delete(Long id) {
		dao.delete(id);	
	}

	public Ministere findById(Long id) {
		
		return dao.findById(id);
	}

	public MinistereDao getDao() {
		return dao;
	}

	public void setDao(MinistereDao dao) {
		this.dao = dao;
	}

}
