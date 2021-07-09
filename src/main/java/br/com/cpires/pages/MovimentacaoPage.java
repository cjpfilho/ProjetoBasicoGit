package br.com.cpires.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.cpires.core.BasePage;
import br.com.cpires.core.DriverFactory;

public class MovimentacaoPage extends BasePage {
	
//	Seleção em combobox
	public void selecionaMovimentacao(String tipoMov) {
		selecionarCombo("tipo", tipoMov);
	}
	
	public void selecionaSituacaoPago() {
		clicarRadio("status_pago");
	}
	
	public void selecionaConta (String conta) {
		selecionarCombo("conta", conta);
	}
	
//	Preenchimento de campos
	public void preencheDataMovimentacao(String data) {
		escrever("data_transacao", data);
	}
	
	public void preencheDataPagamento(String data) {
		escrever("data_pagamento", data);
	}
	
	public void preencheDescricao(String desc) {
		escrever("descricao", desc);
	}
	
	public void preencheInteressado(String interessado) {
		escrever("interessado", interessado);
	}

	public void preencheValor(String valor) {
		escrever("valor", valor);
	}
	
//	Clique em radio e botões
	public void selecionaSituacaoPendente() {
		clicarRadio("status_pendente");
	}
	
	public void clicaBotaoSalvar() {
		clicarBotao(By.xpath("//button[.='Salvar']"));	
	}
	
//	Obtenção de mensagens do alerta da tela
	public String obtemResultadoInclusao() {
		return obterTexto(By.xpath("//div[@role='alert']"));
	}
	
//	Cria uma lista de WebElements, passa o getText() de cada elemento para uma lista de Strings
//	e retorna a lista
	public List<String> obtemMensagensErro () {
		List<WebElement> erros = DriverFactory.getDriver().findElements(By.xpath("//div[@role='alert']//li"));
		List<String> mensagens = new ArrayList<String>();
		for (WebElement erro  : erros) {
			mensagens.add(erro.getText());
		}
		System.out.println(mensagens);
		return mensagens;
	}
		
}
