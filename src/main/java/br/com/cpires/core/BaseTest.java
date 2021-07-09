package br.com.cpires.core;

import static br.com.cpires.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.com.cpires.pages.LoginPage;

public class BaseTest {
	
	private LoginPage login = new LoginPage();
	
	@Rule
	public TestName testName = new TestName();
	
	@Before
	public void inicializa() {
		login.acessaTelaInicial();
		login.preencherEmail("sos.rans@gmail.com");
		login.preencherSenha("teste123");
		login.clicarBotaoEntrar();
	}
	
	@After
	public void finaliza() throws IOException{
		
		TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" + File.separator +
				testName.getMethodName() + ".jpg"));
		
		if (Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
	}
}
