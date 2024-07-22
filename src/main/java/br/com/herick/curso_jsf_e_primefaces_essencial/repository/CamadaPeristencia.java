package br.com.herick.curso_jsf_e_primefaces_essencial.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.herick.curso_jsf_e_primefaces_essencial.model.Empresa;
import br.com.herick.curso_jsf_e_primefaces_essencial.model.RamoAtividade;
import br.com.herick.curso_jsf_e_primefaces_essencial.model.TipoEmpresa;

public class CamadaPeristencia {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlgaworksPU");
		
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		// Declarando Repositório
		RamoAtividades ramoAtividades = new RamoAtividades(em);
		Empresas empresas = new Empresas(em);

		// buscando as informalções do banco
		List<RamoAtividade> listaDeRamoAtividades = ramoAtividades.pesquisar("");
		List<Empresa> listaDeEmpresas = empresas.pesquisar("");
		System.out.println(listaDeEmpresas);

		// criando Epresa
		Empresa empresa = new Empresa();
		empresa.setNomeFantasia("Herick Alves");
		empresa.setCnpj("13.821.817/0001-46");
		empresa.setRazaoSocial("Herick Alves 13.821.817/0001-46");
		empresa.setTipoEmpresa(TipoEmpresa.MEI);
		empresa.setDataFundacao(new Date());
		empresa.setRamoAtividade(listaDeRamoAtividades.get(0));

		// salvando Empresa
		empresas.guardar(empresa);

		em.getTransaction().commit();

		// Verificando se a inserção funcionou
		List<Empresa> listaEmpresa2 = empresas.pesquisar("");
		System.out.println(listaEmpresa2);
		
		
		em.close();
		emf.close();

	}
}
