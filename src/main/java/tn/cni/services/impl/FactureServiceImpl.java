package tn.cni.services.impl;

import java.util.List;

import tn.cni.dao.FactureDao;
import tn.cni.dao.FactureJpaDao;
import tn.cni.domain.Facture;
import tn.cni.services.FactureService;

/**
 * 
 * @author hasna
 *
 */

public class FactureServiceImpl implements FactureService{

	
FactureDao factureDao = new FactureJpaDao();
	
	public List<Facture> findAll() {
		
		return factureDao.findAll();
	}

	public void add(Facture facture) {
		factureDao.add(facture);
		
	}

	public Facture edit(Facture facture) {
		
		return factureDao.edit(facture);
	}

	public void delete(Long id) {
		factureDao.delete(id);	
	}

	public Facture findById(Long id) {
		
		return factureDao.findById(id);
	}

	public FactureDao getFactureDao() {
		return factureDao;
	}

	public void setFactureDao(FactureDao factureDao) {
		this.factureDao = factureDao;
	}

	







}
