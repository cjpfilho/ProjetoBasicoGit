package br.com.cpires.pages;

import org.openqa.selenium.By;

import br.com.cpires.core.BasePage;
import br.com.cpires.core.DriverFactory;

public class LoginPage extends BasePage {
	
	public void acessaTelaInicial() {
		DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/login");
	}
	
	public void preencherEmail(String email) {
		escrever("email", email);
	}
	
	public void preencherSenha(String senha) {
		escrever("senha", senha);
	}
	
	public void clicarBotaoEntrar() {
		clicarBotao(By.xpath("//button[.='Entrar']"));
	}
}
	
