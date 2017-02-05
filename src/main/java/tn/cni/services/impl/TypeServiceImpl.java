package tn.cni.services.impl;

import java.util.List;

import tn.cni.dao.TypeDao;
import tn.cni.dao.TypeJpaDao;
import tn.cni.domain.Type;
import tn.cni.services.TypeService;

public class TypeServiceImpl implements TypeService{
	
	
	TypeDao dao = new TypeJpaDao();
	public List<Type> findAll() {
		
		return dao.findAll();
	}

}
