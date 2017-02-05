package tn.cni.dao;

import java.util.List;

import tn.cni.domain.Role;

public interface RoleDao {
	
    public void add(Role role);
	
	public Role edit(Role role);
	
	public void delete(Long id);
	
	public List<Role> findAll();
	
	public Role findById(Long id);
}
