package tn.cni.services.impl;

import java.util.List;

import tn.cni.dao.RoleDao;
import tn.cni.dao.RoleJpaDao;
import tn.cni.domain.Role;
import tn.cni.services.RoleService;

public class RoleServiceImpl implements RoleService{
	
	RoleDao dao = new RoleJpaDao();
	
	public List<Role> findAll() {
		
		return dao.findAll();
	}

	public void add(Role role) {
		dao.add(role);
		
	}

	public Role edit(Role role) {
		
		return dao.edit(role);
	}

	public void delete(Long id) {
		dao.delete(id);	
	}

	public Role findById(Long id) {
		
		return dao.findById(id);
	}

	public RoleDao getDao() {
		return dao;
	}

	public void setDao(RoleDao dao) {
		this.dao = dao;
	}

	


}
