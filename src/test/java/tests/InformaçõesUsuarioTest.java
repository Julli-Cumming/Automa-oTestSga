package tests;

import static  org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InformaçõesUsuarioTest {
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(){
        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver","C:\\Users\\jcumming\\Drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();

        // Navagando para a pagina de login - colocar o link de acesso do sistema
        navegador.get("http://www.juliodelima.com.br/taskit");

        // Clicar no link que possui o texto Sign in
        navegador.findElement(By.linkText("Sing in")).click();
        //WebElement linkSignIn = navegador.findElement(By.linkText("Sing in"));
        //linkSignIn.click();


        //clicar no campo com name login que está dentro do formulário de id "signinbox"
        WebElement formularioSignInbox = navegador.findElement(By.id("signinbox"));



        //Digitar no campo com name login que está dentro do formulário de id "signinbox" o texto "julio0001"

        //clicar no campo com name password que está dentro do formulário de id "signinbox"

        //Digitar no campo com name password que está dentro do formulário de id "signinbox" o texto "123456"

        //Clicar no link com o texto "SIGN IN"

        //Validar que dentro do elemento com class "me" está o texto "Hi, julio"


        navegador.find


       assertEquals(1,1);

    }
}
