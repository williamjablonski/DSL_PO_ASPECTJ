package br.com.locaweb.suite;

import org.junit.Test;

import br.com.locaweb.po.HomePO;


public class BuscaDSL extends HomePO {

		@Test
		public void testBuscarpeloBotao() throws Exception {

			for (int i = 1; i < planilha.getLinhas(); i++, planilha.setLinhaAtual(planilha.getLinhaAtual() + 1)) {
				
				abrirHomeDaRadio();
				buscarArtistaBotao(planilha.coluna("Artista"));
				validarSucessoDaBusca(planilha.coluna("Artista"));
				
			}
		}

}