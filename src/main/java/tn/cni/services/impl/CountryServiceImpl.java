package tn.cni.services.impl;

import java.util.List;

import tn.cni.dao.CountryDao;
import tn.cni.dao.CountryJpaDao;
import tn.cni.domain.Country;
import tn.cni.services.CountryService;

public class CountryServiceImpl implements CountryService{

CountryDao dao = new CountryJpaDao();
	
	public List<Country> findAll() {
		
		return dao.findAll();
	}
	
}
