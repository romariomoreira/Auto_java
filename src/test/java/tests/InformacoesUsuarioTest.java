package tests;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class InformacoesUsuarioTest {
    private WebDriver navegador;

    @Before
    public void setUp(){

        //Abrindo Navegador
        System.setProperty("webdriver.chrome.driver","C:\\auto\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Navegando para site task
        navegador.get("http://www.juliodelima.com.br/taskit");


    }



    @Test
    public void testAdicionaruminformacaodousuario(){
        //Clicar no link que possui o texto "Sign in"
        navegador.findElement(By.linkText("Sign in")).click();


        //Identificando Formulário de Login
        WebElement formularioSingnInBox = navegador.findElement(By.id("signinbox"));

        //Digitar no campo name "Login" que está dentro do formulário de ID "signinbox" o texto "julio0001"
        formularioSingnInBox.findElement(By.name("login")).sendKeys("julio0001");

        //Digitar no campo name "Password" que está dentro do formulário de ID "signinbox" o texto "123456"
        formularioSingnInBox.findElement(By.name("password")).sendKeys("123456");


        //Clicar no link com texto "SIGN IN"
        formularioSingnInBox.findElement(By.linkText("SIGN IN")).click();

        //Clicar em um link que possui a class "me"
        navegador.findElement(By.className("me")).click();
        //Clicar em um link que possui o texto "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
        //Clicar no botão atráves do seu xpath //button[@data-target="addmoredata"]
        navegador.findElement(By.xpath("//button[@data-target=\'addmoredata\']")).click();

        // Identificar a popup onde está o fomulário de id addmoredata
        WebElement formularioaddmoredata = navegador.findElement(By.id("addmoredata"));

        //No combo de name "type" escolhe a opção "Phone"
      //  formularioaddmoredata.findElement(By.name("type").findElement(By.cssSelector("Phone"))

        // No campo de name "Contact" digitar "+5511933293399"

        //clicar no link de text "SAVE" que esrá na popup

    // Na mensagem de id "toast-container" validar que o texto é "Your contact has been added!"






    }

@After

    public void tearDown(){
//Fechar o navegador
    //navegador.quit();
    //assertEquals(1,1);

}


}


//Validar que dentro do elemento com class "me" está o texto "Hi, Julio"
// WebElement me = navegador.findElement(By.className("me"));
//String TextoElementoME = me.getText();
//assertEquals("Hi, Julio",TextoElementoME);