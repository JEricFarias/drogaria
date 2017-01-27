package br.org.drogaria.dao;

import org.junit.Test;

import br.org.drogaria.domain.Fabricante;

public class FabricanteDAOTest {
	@Test
	public void salvarFabricanteTest(){
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("Coca-Cola");
		
		FabricanteDAO dao = new FabricanteDAO();
		dao.salvar(fabricante); 
	}
}
