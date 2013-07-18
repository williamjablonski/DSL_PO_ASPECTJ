package br.com.locaweb.config;
import junit.framework.TestCase;

import org.junit.Ignore;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

@Ignore
public abstract class SeleniumEduardo extends TestCase 
{
	protected static Selenium selenium;	
	protected static Suporte planilha;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
        selenium = new DefaultSelenium(
        		"localhost", 
        		4444, 
        		"*chrome",
        		"http://radio.uol.com.br");
        selenium.start();
        selenium.windowFocus();
        selenium.windowMaximize();
        selenium.setSpeed("1000");
	}
 
    @Override
    protected void tearDown() throws Exception {
    	super.tearDown();
    	selenium.stop();
    }
}
