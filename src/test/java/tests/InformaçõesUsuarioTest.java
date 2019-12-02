package tests;

import static  org.junit.Assert.*;

import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.Screenshort;

import java.util.concurrent.TimeUnit;

public class InformaçõesUsuarioTest {
    private  WebDriver navegador;

    @Rule
    public TestName test = new TestName();

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
    }
   // @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(){

        //Clicar no botão através do seu xpath
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        //Identificar o popup onde está o formulário de id "addmoredata"
        WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));

        //No combo de name "type" escolher a opção "Phone"
        WebElement campoType = popupAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText("Phone");

        //No combo de name "contact" digitar "+5571987456987"
        popupAddMoreData.findElement(By.name("contact")).sendKeys("+5571987456987");

        //No combo de name "type" escolher a opção "Email"
        //WebElement campoType = popupAddMoreData.findElement(By.name("type"));
        //new Select(campoType).selectByVisibleText("E-mail");

        ////No combo de name "contact" digitar "teste2020@gmail.com"
        //popupAddMoreData.findElement(By.name("contact")).sendKeys("teste2020@gmail.com");

        //Clicar no link de text "SAVE" que está na popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();

        //Na mensagem de id "toast-container" validar que o texto  é "Your contact has been added!"
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        assertEquals("Your contact has been added!",mensagem);
    }

    @Test
    public void removerUmContatoDeUmUsuario(){
        //Clicar no elemento pelo xpath //span[text()="+5571987456987"]following-sibling::a
        navegador.findElement(By.xpath("//span[text()=\"+5571987456987\"]/following-sibling::a")).click();
        //navegador.findElement(By.xpath("//span[text()=\"teste2020@gmail.com\"]/following-sibling::a")).click();

        //Confirmar a janela javascript
        navegador.switchTo().alert().accept();

        //Validar que a mensagem validada foi "Rest in peace,dear phone!"
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        //assertEquals("Rest in peace, dear phone!",mensagem);
        assertEquals("Rest in peace, dear email!",mensagem);

        String screenshortArquivo = "C:\\Users\\jcumming\\Downloads" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshort.tirar(navegador, screenshortArquivo);

        //Aguardar ate 10 segundos para que a janela desapareça (usa-se uma espera explicita)
        WebDriverWait aguardar = new WebDriverWait(navegador, 10);
        aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));

        //Clicar no link com o texto logout
        navegador.findElement(By.linkText("Logout")).click();
    }
      @After
    public void tearDown(){
        //Fechar a navegação
          navegador.quit();
    }
}
