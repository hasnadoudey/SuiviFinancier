package tn.cni.services.impl;

import java.util.List;

import tn.cni.dao.ProjetDao;
import tn.cni.dao.ProjetJpaDao;
import tn.cni.domain.Projet;
import tn.cni.services.ProjetService;


public class ProjetServiceImpl implements ProjetService{

	ProjetDao projetdao = new ProjetJpaDao();
	
	public List<Projet> findAll() {
		
		return projetdao.findAll();
	}

	public void add(Projet projet) {
		projetdao.add(projet);
		
	}

	public Projet edit(Projet projet) {
		
		return projetdao.edit(projet);
	}

	public void delete(Long id) {
		projetdao.delete(id);	
	}

	public Projet findById(Long id) {
		
		return projetdao.findById(id);
	}

	public ProjetDao getProjetdao() {
		return projetdao;
	}

	public void setProjetdao(ProjetDao projetdao) {
		this.projetdao = projetdao;
	}

	

	


	
	
}
