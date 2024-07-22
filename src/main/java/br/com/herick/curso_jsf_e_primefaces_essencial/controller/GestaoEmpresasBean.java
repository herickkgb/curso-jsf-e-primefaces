package br.com.herick.curso_jsf_e_primefaces_essencial.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.herick.curso_jsf_e_primefaces_essencial.model.Empresa;
import br.com.herick.curso_jsf_e_primefaces_essencial.model.RamoAtividade;
import br.com.herick.curso_jsf_e_primefaces_essencial.model.TipoEmpresa;
import br.com.herick.curso_jsf_e_primefaces_essencial.repository.Empresas;
import br.com.herick.curso_jsf_e_primefaces_essencial.repository.RamoAtividades;
import br.com.herick.curso_jsf_e_primefaces_essencial.util.FacesMessages;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private Empresas empresas;
    
    @Inject
    private FacesMessages messages;
    
    @Inject
    private RamoAtividades ramoAtividades;
    
    private List<Empresa> listaEmpresas;
    
    private String termoPesquisa;
    
    private Converter ramoAtividadeConverter;
    
    public void pesquisar() {
        listaEmpresas = empresas.pesquisar(termoPesquisa);
        
        if (listaEmpresas.isEmpty()) {
            messages.info("Sua consulta não retornou registros.");
        }
    }
    
    public void todasEmpresas() {
        listaEmpresas = empresas.todas();
    }
    
    public List<RamoAtividade> completarRamoAtividade(String termo) {
        List<RamoAtividade> listaRamoAtividades = ramoAtividades.pesquisar(termo);
        
        ramoAtividadeConverter = new RamoAtividadeConverter(listaRamoAtividades);
        
        return listaRamoAtividades;
    }
    
    public List<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }
    
    public String getTermoPesquisa() {
        return termoPesquisa;
    }
    
    public void setTermoPesquisa(String termoPesquisa) {
        this.termoPesquisa = termoPesquisa;
    }
    
    public TipoEmpresa[] getTiposEmpresa() {
        return TipoEmpresa.values();
    }
    
    public Converter getRamoAtividadeConverter() {
        return ramoAtividadeConverter;
    }
}