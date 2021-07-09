package br.com.cpires.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.cpires.core.BaseTest;
import br.com.cpires.pages.MenuPage;
import br.com.cpires.pages.ResumoPage;

public class ResumoTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private ResumoPage resumo = new ResumoPage();
	
	@Test
	public void excluirPrimeiraMovimentacao() {
		menu.clicaMenuResumo();
		resumo.excluiPrimeiroRegistro();
		
		Assert.assertEquals("Movimentação removida com sucesso!", resumo.obtemResultadoExclusao());
	}
}
