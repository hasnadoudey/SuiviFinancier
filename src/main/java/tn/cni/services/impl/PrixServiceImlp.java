package tn.cni.services.impl;

import java.util.List;

import tn.cni.dao.PrixDao;
import tn.cni.dao.PrixJpaDao;
import tn.cni.domain.Prix;
import tn.cni.services.PrixService;

public class PrixServiceImlp implements PrixService{

   PrixDao dao = new PrixJpaDao();
	
	public List<Prix> findAll() {
		
		return dao.findAll();
	}
}
