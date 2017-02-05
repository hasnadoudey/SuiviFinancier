package tn.cni.services.impl;

import java.util.List;

import tn.cni.dao.OperateurDao;
import tn.cni.dao.OperateurJpaDao;
import tn.cni.domain.Operateur;
import tn.cni.services.OperateurService;

public class OperateurServiceImpl implements OperateurService{

OperateurDao operateurdao = new OperateurJpaDao();
	


	public List<Operateur> findAll() {
		
		return operateurdao.findAll();
	}

	public void add(Operateur operateur) {
		operateurdao.add(operateur);
		
	}

	public Operateur edit(Operateur operateur) {
		
		return operateurdao.edit(operateur);
	}

	public void delete(Integer id) {
		operateurdao.delete(id);	
	}
	
	public Operateur findById(Integer id) {
		
		return operateurdao.findById(id);
	}

	public OperateurDao getOperateurdao() {
		return operateurdao;
	}

	public void setOperateurdao(OperateurDao operateurdao) {
		this.operateurdao = operateurdao;
	}


	
	
}
