package br.com.herick.curso_jsf_e_primefaces_essencial.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.herick.curso_jsf_e_primefaces_essencial.model.RamoAtividade;

public class RamoAtividades implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public RamoAtividades() {
		// none
	}

	public RamoAtividades(EntityManager manager) {
		this.manager = manager;
	}

	public List<RamoAtividade> pesquisar(String descricao) {
		TypedQuery<RamoAtividade> query = this.manager.createQuery("from RamoAtividade where descricao like :descricao",
				RamoAtividade.class);
		query.setParameter("descricao", descricao + "%");
		return query.getResultList();
		
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

}
