package br.com.locaweb.po;
import br.com.locaweb.config.SeleniumEduardo;



public class HomePO extends SeleniumEduardo {

	public void validarSucessoDaBusca(String artista) throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= 5) fail("timeout");
			try { if (selenium.isTextPresent("Você buscou por " + artista)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
	}

	public void buscarArtistaBotao(String artista) {
		selenium.type("id=q", artista);
		selenium.click("id=submitbutton");
	}

	public void abrirHomeDaRadio() {
		selenium.open("/");
	}

}