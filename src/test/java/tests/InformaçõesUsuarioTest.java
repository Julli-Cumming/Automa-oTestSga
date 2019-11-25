package tests;

import static  org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InformaçõesUsuarioTest {
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(){
        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver","C:\\Users\\jcumming\\Drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();

        // Navagando para a pagina de login - colocar o link de acesso do sistema
        navegador.get("http://www.juliodelima.com.br/taskit");


       assertEquals(1,1);

    }
}
