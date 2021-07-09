package br.com.cpires.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.cpires.core.BaseTest;
import br.com.cpires.pages.ContasPage;
import br.com.cpires.pages.MenuPage;

public class ContaTest extends BaseTest {
	
	private ContasPage contas = new ContasPage();
	private MenuPage menu = new MenuPage();
	
	@Test
	public void testeInserirConta() {
		menu.clicaMenuContas();
		menu.clicaMenuAdicionar();
		contas.insereNomeConta("Celio teste");
		contas.clicabotaoSalvar();
		Assert.assertEquals("Conta adicionada com sucesso!", contas.obtemResultadoInclusao());
	}
	
	@Test
	public void testeInserirContaDuplicada() {
		menu.clicaMenuContas();
		menu.clicaMenuAdicionar();
		contas.insereNomeConta("Celio teste");
		contas.clicabotaoSalvar();
		Assert.assertEquals("Já existe uma conta com esse nome!", contas.obtemResultadoInclusao());
	}
	
	@Test
	public void alteraConta() {
		menu.clicaMenuContas();
		menu.clicaMenuListar();
		contas.editarPrimeiroRegistro();
		contas.insereNomeConta("Conta Alterada");
		contas.clicabotaoSalvar();
		Assert.assertEquals("Conta alterada com sucesso!", contas.obtemResultadoInclusao());
	}
}
