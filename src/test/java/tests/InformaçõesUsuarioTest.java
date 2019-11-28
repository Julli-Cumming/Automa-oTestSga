package tests;

import static  org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class InformaçõesUsuarioTest {
    private  WebDriver navegador;
    @Before
    public void setUp(){
        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver","C:\\Users\\jcumming\\Drivers\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegador.get("http://www.juliodelima.com.br/taskit");
        navegador.manage().window().maximize();
        // Clicar no link que possui o texto "Sign in"
        navegador.findElement(By.linkText("Sign in")).click();
    }
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(){


        // Identificando o formulário Login
        WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));

        // digitar no campo com name "login" que está dentro do formulário "signinbox" o texto "julio0001"
        formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");

        // digitar no campo com name "password" que está dentro do formulário "signinbox" o texto "123456"
        formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

        // clicar no link com texto "SIGN IN"
        navegador.findElement(By.linkText("SIGN IN")).click();

        //Clicar em um link que possui a class "me"
         navegador.findElement(By.className("me")).click();

        //Clicar em um link que possui o texto "MORE DATA ABOUT YOU'
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        //Clicar no botão através do seu xpath
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        //Identificar o popup onde está o formulário de id "addmoredata"
        WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));

        //No combo de name "type" escolher a opção "Phone"
        WebElement campoType = popupAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText("Phone");

        //No combo de name "contact" digitar "+5571987456987"
        popupAddMoreData.findElement(By.name("contact")).sendKeys("+5571987456987");

        //Clicar no link de text "SAVE" que está na popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();

        //Na mensagem de id "toast-container" validar que o texto  é "Your contact has been added!"


        //Validar que dentro do elemento com class "me" está o texto "Hi, julio"
        //WebElement me = navegador.findElement(By.className("me"));
       // String textoNoElementoMe = me.getText();
       // assertEquals("Hi, Julio",textoNoElementoMe);


    }
      @After
    public void tearDown(){
         // navegador.quit();
    }
}
