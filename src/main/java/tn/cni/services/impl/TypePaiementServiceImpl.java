package tn.cni.services.impl;

import java.util.List;

import tn.cni.dao.TypePaiementDao;
import tn.cni.dao.TypePaiementJpaDao;
import tn.cni.domain.TypePaiement;
import tn.cni.services.TypePaiementService;

public class TypePaiementServiceImpl implements TypePaiementService{
	
	
	TypePaiementDao dao = new TypePaiementJpaDao();
	


	public List<TypePaiement> findAll() {
		
		return dao.findAll();
	}

	public void add(TypePaiement typePaiement) {
		dao.add(typePaiement);
		
	}

	public TypePaiement edit(TypePaiement typePaiement) {
		
		return dao.edit(typePaiement);
	}

	public void delete(Long id) {
		dao.delete(id);	
	}

	public TypePaiement findById(Long id) {
		
		return dao.findById(id);
	}

	public TypePaiementDao getDao() {
		return dao;
	}

	public void setDao(TypePaiementDao dao) {
		this.dao = dao;
	}


}
