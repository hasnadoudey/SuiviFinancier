package tn.cni.services.impl;

import java.util.List;

import tn.cni.dao.FournisseurDao;
import tn.cni.dao.FournisseurJpaDao;
import tn.cni.domain.Fournisseur;
import tn.cni.services.FournisseurService;

public class FournisseurServiceImpl implements FournisseurService{

	
	FournisseurDao fournisseurdao = new FournisseurJpaDao();
	
	public List<Fournisseur> findAll() {
		
		return fournisseurdao.findAll();
	}

	public void add(Fournisseur fournisseur) {
		fournisseurdao.add(fournisseur);
		
	}

	public Fournisseur edit(Fournisseur fournisseur) {
		
		return fournisseurdao.edit(fournisseur);
	}

	public void delete(Long id) {
		fournisseurdao.delete(id);	
	}

	public Fournisseur findById(Long id) {
		
		return fournisseurdao.findById(id);
	}

	public FournisseurDao getFournisseurdao() {
		return fournisseurdao;
	}

	public void setFournisseurdao(FournisseurDao fournisseurdao) {
		this.fournisseurdao = fournisseurdao;
	}

		

	
}
