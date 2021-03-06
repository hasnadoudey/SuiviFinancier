package tn.cni.dao;

import java.util.List;

import tn.cni.domain.Account;

public interface AccountDao {
	
	
	     public void add(Account account);
		
		public Account edit(Account account);
		
		public void delete(Long id);
		
		public List<Account> findAll();
		
		public Account findById(Long id);
}
