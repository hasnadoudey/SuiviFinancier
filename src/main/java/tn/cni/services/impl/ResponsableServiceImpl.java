package tn.cni.services.impl;

import java.util.List;

import tn.cni.dao.ResponsableDao;
import tn.cni.dao.ResponsableJpaDao;
import tn.cni.domain.Responsable;
import tn.cni.services.ResponsableService;

public class ResponsableServiceImpl implements ResponsableService{
	
ResponsableDao responsabledao = new ResponsableJpaDao();


public ResponsableDao getResponsabledao() {
	return responsabledao;
}

public void setResponsabledao(ResponsableDao responsabledao) {
	this.responsabledao = responsabledao;
}
	
	public List<Responsable> findAll() {
		
		return responsabledao.findAll();
	}

	public void add(Responsable responsable) {
		responsabledao.add(responsable);
		
	}

	
	
	
	public void delete(Integer id) {
		responsabledao.delete(id);	
	}

	public Responsable findById(Integer id) {
		
		return responsabledao.findById(id);
	}

	public Responsable edit(Responsable responsable) {
		
		return responsabledao.edit(responsable);
	}

	
    }

	
	
	
	
	
	
	
	
	

