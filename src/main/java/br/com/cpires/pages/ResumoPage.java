package br.com.cpires.pages;

import org.openqa.selenium.By;

import br.com.cpires.core.BasePage;

public class ResumoPage extends BasePage {

	public void excluiPrimeiroRegistro() {
		clicarBotao(By.className("glyphicon-remove-circle"));
	}
	
	public String obtemResultadoExclusao() {
		return obterTexto(By.xpath("//div[@role='alert']"));
	}
}
