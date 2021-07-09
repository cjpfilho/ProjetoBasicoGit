package br.com.cpires.pages;

import org.openqa.selenium.By;

import br.com.cpires.core.BasePage;

public class MenuPage extends BasePage{
	
	public void clicaMenuContas() {
		clicarBotao(By.xpath("//a[contains(text(),\"Contas\")]"));
	}
	
	public void clicaMenuAdicionar() {
		clicarLink("Adicionar");
	}
	
	public void clicaMenuListar() {
		clicarLink("Listar");
	}
	
	public void clicaMenuMovimentacao() {
		clicarLink("Criar Movimentação");
	}
	
	public void clicaMenuResumo() {
		clicarLink("Resumo Mensal");
	}
	
}
