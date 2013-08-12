package br.com.locaweb.po;
import br.com.locaweb.config.SeleniumEduardo;



public class HomePO extends SeleniumEduardo {

	public void abrirHomeDaRadio() {
		selenium.open("/");
	}
	
	public void buscarArtistaBotao(String artista) {
		for (int second = 0;; second++) {
			if (second >= 30) fail("timeout");
			try { if (selenium.isElementPresent("id=q")) break; } catch (Exception e) {}
			try {Thread.sleep(1000);} catch (Exception e) {} 
		}
		selenium.type("id=q", artista);
		selenium.click("id=submitbutton");
	}
	
	public void validarSucessoDaBusca(String artista) throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= 30) fail("timeout");
			try { if (selenium.isTextPresent("Você buscou por " + artista.toLowerCase())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
	}
}