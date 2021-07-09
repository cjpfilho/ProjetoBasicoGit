package br.com.cpires.pages;

import org.openqa.selenium.By;

import br.com.cpires.core.BasePage;

public class ContasPage extends BasePage {

	public void insereNomeConta(String nomeConta) {
		escrever("nome", nomeConta);
	}
	
	public void clicabotaoSalvar() {
		clicarBotao(By.xpath("//button[.='Salvar']"));
	}
	
	public void editarPrimeiroRegistro() {
		clicarBotao(By.className("glyphicon-edit"));
	}
	
	public String obtemResultadoInclusao() {
		return obterTexto(By.xpath("//div[@role='alert']"));	
	}
	
}
