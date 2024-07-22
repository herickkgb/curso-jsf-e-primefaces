package br.com.herick.curso_jsf_e_primefaces_essencial.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.herick.curso_jsf_e_primefaces_essencial.model.Empresa;
import br.com.herick.curso_jsf_e_primefaces_essencial.repository.Empresas;
import br.com.herick.curso_jsf_e_primefaces_essencial.util.Transacional;

public class CadastroEmpresaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Empresas empresas;

    @Transacional
    public void salvar(Empresa empresa) {
        empresas.guardar(empresa);
    }

    @Transacional
    public void excluir(Empresa empresa) {
        empresas.remover(empresa);
    }

}