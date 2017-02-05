package tn.cni.services.impl;

import java.util.List;

import tn.cni.dao.DeviseDao;
import tn.cni.dao.DeviseJpaDao;
import tn.cni.domain.Devise;
import tn.cni.services.DeviseService;

public class DeviseServiceImpl implements DeviseService {
  DeviseDao dao = new DeviseJpaDao();
	
	public List<Devise> findAll() {
		
		return dao.findAll();
	}
	
}
