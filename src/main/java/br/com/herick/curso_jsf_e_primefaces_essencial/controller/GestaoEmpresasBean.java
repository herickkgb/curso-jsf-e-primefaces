package br.com.herick.curso_jsf_e_primefaces_essencial.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.herick.curso_jsf_e_primefaces_essencial.model.Empresa;
import br.com.herick.curso_jsf_e_primefaces_essencial.repository.Empresas;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private Empresas empresas;

    private List<Empresa> listaEmpresas;
    
    public List<Empresa> todasEmpresas(){
    	this.listaEmpresas = empresas.todas();
    	return this.listaEmpresas;
    }
    
    public List<Empresa> getListaEmpresas() {
		return this.listaEmpresas;
	}
   
}