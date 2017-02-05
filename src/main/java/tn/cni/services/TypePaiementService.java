package tn.cni.services;

import java.util.List;

import tn.cni.domain.TypePaiement;

public interface TypePaiementService {

	   public void add(TypePaiement typePaiement);
		
		public List<TypePaiement> findAll();
		
		public TypePaiement edit(TypePaiement typePaiement);
			
		public void delete(Long id);
			
		public TypePaiement findById(Long id);
}
