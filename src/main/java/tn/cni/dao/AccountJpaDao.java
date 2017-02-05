package tn.cni.dao;

import java.util.List;

import org.hibernate.Session;

import tn.cni.domain.Account;
import tn.cni.ui.utils.HibernateUtil;

public class AccountJpaDao implements AccountDao{

	
	 Session session = HibernateUtil.openSession();
		
	    @SuppressWarnings("unchecked")
		public List<Account> findAll() {
		return session.createQuery("select e from Account e ").list();
		
	
	}

	
       public void add(Account account) {
	
		session.beginTransaction();
		session.save(account);
		session.getTransaction().commit();
		

	}

	
		public Account edit(Account account) {
			session.beginTransaction();
			Account e =(Account)session.merge(account);
			session.getTransaction().commit();
			return e;
		}
	

		public void delete(Long id) {
		session.beginTransaction();
		Account e =findById(id);
	    session.delete(e);
	    session.getTransaction().commit();	
		}


		public Account findById(Long id) {
		
	    return (Account) session.get(Account.class,id);
		}


	

	
		
	
}
