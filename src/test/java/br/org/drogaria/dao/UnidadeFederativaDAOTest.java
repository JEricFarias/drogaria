package br.org.drogaria.dao;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.org.drogaria.domain.UnidadeFederativa;

public class UnidadeFederativaDAOTest {
	@Test
	@Ignore
	public void salvarTest(){
		UnidadeFederativa uf = new UnidadeFederativa();
		uf.setNome("São Paulo");
		uf.setSigla("SP");
		
		UnidadeFederativaDAO unidadeFederativaDAO = new UnidadeFederativaDAO();
		unidadeFederativaDAO.salvar(uf);
	}
	
	@Test
	public void listarTest(){
		UnidadeFederativaDAO ufDAO = new UnidadeFederativaDAO();
		List<UnidadeFederativa> uf = ufDAO.listar();
		
		for(UnidadeFederativa estado: uf){
			System.out.println("Nome: " + estado.getNome() +"(" + estado.getSigla() +")");
		}
	}
	
	@Test
	public void buscar(){
		UnidadeFederativaDAO ufd = new UnidadeFederativaDAO();
		UnidadeFederativa uf = ufd.buscar(3L);
		
		System.out.println("Codigo: " + uf.getCodigo() + " - Sigla: " + uf.getSigla() + " - Nome: " + uf.getNome());
	}
}
