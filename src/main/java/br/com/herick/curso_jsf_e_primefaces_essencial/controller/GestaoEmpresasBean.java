package br.com.herick.curso_jsf_e_primefaces_essencial.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.herick.curso_jsf_e_primefaces_essencial.model.Empresa;
import br.com.herick.curso_jsf_e_primefaces_essencial.model.TipoEmpresa;


@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Empresa empresa = new Empresa();
    
    public void salvar() {
        System.out.println("Razão social: " + empresa.getRazaoSocial()
                + " - Nome fantasia: " + empresa.getNomeFantasia()
                + " - Tipo: " + empresa.getTipo());
    }
    
    public String ajuda() {
        return "AjudaGestaoEmpresas?faces-redirect=true";
    }
    
    public String voltar() {
        return "GestaoEmpresas?faces-redirect=true";
    }
    
    
    
    public Empresa getEmpresa() {
        return empresa;
    }
    
    public TipoEmpresa[] getTiposEmpresa() {
        return TipoEmpresa.values();
    }
}