package tn.cni.services.impl;

import java.util.List;

import tn.cni.dao.EtatDao;
import tn.cni.dao.EtatJpaDao;
import tn.cni.domain.Etat;
import tn.cni.services.EtatService;

public class EtatServiceImpl implements EtatService{
	
	
	
       EtatDao etatdao = new EtatJpaDao();
	
	public List<Etat> findAll() {
		
		return etatdao.findAll();
	}
	public EtatDao getEtatdao() {
		return etatdao;
	}



	public void setEtatdao(EtatDao etatdao) {
		this.etatdao = etatdao;
	}



	public Etat edit(Etat etat) {
		
		return etatdao.edit(etat);
	}

	public void delete(Integer id) {
		etatdao.delete(id);	
	}

	public Etat findById(Integer id) {
		
		return etatdao.findById(id);
	}



	public void add(Etat etat) {
		etatdao.add(etat);
		
	}
	
	


}
