package br.com.herick.curso_jsf_e_primefaces_essencial.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.herick.curso_jsf_e_primefaces_essencial.model.Empresa;

public class Empresas implements Serializable {

	private static final long serialVersionUID = -7785873340250523813L;

	@Inject
	private EntityManager manager;

	public Empresas() {
		// none
	}

	public Empresas(EntityManager manager) {
		this.manager = manager;
	}

	public Empresa porId(Long id) {
		return this.manager.find(Empresa.class, id);
	}

	public List<Empresa> pesquisar(String nome) {
		TypedQuery<Empresa> query = this.manager.createQuery("from Empresa where nomeFantasia like :nomeFantasia",
				Empresa.class);
		query.setParameter("nomeFantasia", nome + "%");

		return query.getResultList();
	}

	public Empresa guardar(Empresa empresa) {
		return this.manager.merge(empresa);
	}

	public void remover(Empresa empresa) {
		empresa = porId(empresa.getId());
		this.manager.remove(empresa);
	}

	public List<Empresa> todas() {
		return manager.createQuery("from Empresa", Empresa.class).getResultList();
	}

	public EntityManager getEntityManager() {
		return manager;
	}

	public void setEntityManager(EntityManager manager) {
		this.manager = manager;
	}

}
