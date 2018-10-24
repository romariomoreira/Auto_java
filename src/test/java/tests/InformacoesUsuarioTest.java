package tests;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class InformacoesUsuarioTest {
    private WebDriver navegador;

    @Before
    public void setUp(){

        //Abrindo Navegador
        //Abaixo como é usado para passar o endereço da pasta onde está o navegador, caso esteja em pasta diferente do projeto.
        //System.setProperty("webdriver.chrome.driver","C:\\auto\\chromedriver.exe");

        //Abaixo como é usado para passar o navegador quando estiver na mesma pasta do Projeto.
        System.setProperty("chrome.driver","chromedriver.exe");
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
        WebElement popaddmoredata = navegador.findElement(By.id("addmoredata"));

        //No combo de name "type" escolhe a opção "Phone"
       WebElement CampoType =  popaddmoredata.findElement(By.name("type"));
       new Select(CampoType).selectByVisibleText("Phone");

        // No campo de name "Contact" digitar "+5511933293399"
        popaddmoredata.findElement(By.name("contact")).sendKeys("+5511933293399");

        //clicar no link de text "SAVE" que está na popup
        popaddmoredata.findElement(By.linkText("SAVE")).click();

        // Na mensagem de id "toast-container" validar que o texto é "Your contact has been added!"
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        assertEquals("Your contact has been added!",mensagem);





    }

@After

    public void tearDown(){
//Fechar o navegador

    navegador.quit();
    //assertEquals(1,1);

}


}


//Validar que dentro do elemento com class "me" está o texto "Hi, Julio"
// WebElement me = navegador.findElement(By.className("me"));
//String TextoElementoME = me.getText();
//assertEquals("Hi, Julio",TextoElementoME);