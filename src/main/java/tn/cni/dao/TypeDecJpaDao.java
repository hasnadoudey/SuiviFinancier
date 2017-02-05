package tn.cni.dao;

import java.util.List;

import org.hibernate.Session;

import tn.cni.domain.TypePaiement;
import tn.cni.ui.utils.HibernateUtil;




public class TypeDecJpaDao implements TypeDecDao{

	Session session = HibernateUtil.openSession();

	@SuppressWarnings("unchecked")
	public List<TypePaiement> findAll() {
		return session.createQuery("select o from TypeDec o").list();
	}
	
	
	

}
