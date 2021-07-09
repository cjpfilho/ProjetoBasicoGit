package br.com.cpires.tests;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import Utils.DataUtils;
import br.com.cpires.core.BaseTest;
import br.com.cpires.pages.MenuPage;
import br.com.cpires.pages.MovimentacaoPage;

public class MovimentacaoTest extends BaseTest {
	private MenuPage menu = new MenuPage();
	private MovimentacaoPage movimentacao = new MovimentacaoPage();
	private DataUtils data = new DataUtils();
	
	@Test
	public void incluiMovimentacao() {
		menu.clicaMenuMovimentacao();
		movimentacao.selecionaMovimentacao("Receita");
		movimentacao.preencheDataMovimentacao(data.criarDataAtual());
		movimentacao.preencheDataPagamento(data.criaDataComDiferencaDias(30));
		movimentacao.preencheDescricao("Teste 002");
		movimentacao.preencheInteressado("Paulo Teste");
		movimentacao.preencheValor("100");
		movimentacao.selecionaConta("Conta Alterada");
		movimentacao.selecionaSituacaoPendente();
		movimentacao.clicaBotaoSalvar();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!", movimentacao.obtemResultadoInclusao());
	}
	
	@Test
	public void camposObrigatoriosMovimentacao() {
		menu.clicaMenuMovimentacao();
		movimentacao.clicaBotaoSalvar();
		List<String> mensagens = movimentacao.obtemMensagensErro();
		
//		Na assertiva, eu verifico as mensagens de erro e se a quantidade de mensagens
//		é a quantidade que estou esperando
		Assert.assertTrue(mensagens.containsAll(Arrays.asList(
				"Data da Movimentação é obrigatório",
				"Data do pagamento é obrigatório",
				"Descrição é obrigatório",
				"Interessado é obrigatório",
				"Valor é obrigatório",
				"Valor deve ser um número")));
		Assert.assertEquals(6, mensagens.size());
		
		}
	
	@Test
	public void incluiMovimentacaoFutura() {
		menu.clicaMenuMovimentacao();
		movimentacao.selecionaMovimentacao("Receita");
		movimentacao.preencheDataMovimentacao(data.criaDataComDiferencaDias(1));
		movimentacao.preencheDataPagamento(data.criaDataComDiferencaDias(30));
		movimentacao.preencheDescricao("Teste 001");
		movimentacao.preencheInteressado("Paulo Teste");
		movimentacao.preencheValor("100");
		movimentacao.selecionaConta("Conta Alterada");
		movimentacao.selecionaSituacaoPendente();
		movimentacao.clicaBotaoSalvar();
		
		Assert.assertEquals("Data da Movimentação deve ser menor ou igual à data atual", movimentacao.obtemResultadoInclusao());
	}
	
}
