package tn.cni.services.impl;

import java.util.List;

import tn.cni.dao.AccountDao;
import tn.cni.dao.AccountJpaDao;
import tn.cni.domain.Account;
import tn.cni.services.AccountService;

public class AccountServiceImpl implements AccountService{


    AccountDao accountdao = new AccountJpaDao();
	
	public List<Account> findAll() {
		
		return accountdao.findAll();
	}
	




	public Account edit(Account account) {
		
		return accountdao.edit(account);
	}

	public void delete(Long id) {
		accountdao.delete(id);	
	}

	public Account findById(Long id) {
		
		return accountdao.findById(id);
	}



	public void add(Account account) {
		accountdao.add(account);
		
	}





	public AccountDao getAccountdao() {
		return accountdao;
	}





	public void setAccountdao(AccountDao accountdao) {
		this.accountdao = accountdao;
	}
	
}
