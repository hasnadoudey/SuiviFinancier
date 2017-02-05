package tn.cni.dao;

import java.util.List;

import tn.cni.domain.TypePaiement;

public interface TypePaiementDao {
	
    public void add(TypePaiement typePaiement);
	
	public List<TypePaiement> findAll();
	
	public TypePaiement edit(TypePaiement typePaiement);
		
	public void delete(Long id);
		
	public TypePaiement findById(Long id);
}
