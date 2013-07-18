package br.com.locaweb.aspect;
import java.io.File;

import br.com.locaweb.config.SeleniumEduardo;
import br.com.locaweb.config.Suporte;


public aspect PrintErro extends SeleniumEduardo {
	
	// Ponto de corte	
	pointcut tratamentoFalha() : call (* *.fail(*));	

	// Advice
	before() : tratamentoFalha() {	
		selenium.captureEntirePageScreenshot(new File("pom.xml").getAbsolutePath().replace("pom.xml", "/src/test/resource/Falha.png"), "background=#FFFFFF");

	}	
	
	// Ponto de corte
	pointcut leituraExcel() : execution (* setUp());
	
	
	before() : leituraExcel() {	
		String path = new File("pom.xml").getAbsolutePath().replace("pom.xml", "/src/test/resource/Dados.xls");
		
		planilha = new Suporte("primeira", path);
	}	

}
