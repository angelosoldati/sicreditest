package TaketestWebDriver;

// Importa as bibliotecas do JUnit, Selenium WebDriver, List etc.
import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
 
// Classe JUnit que cont�m os m�todos de teste.
public class TestSicredi {
 
    // Declarando um objeto do tipo WebDriver, utilizado pelo Selenium WebDriver.
    private static WebDriver driver;
 
    // M�todo que inicia tudo que for necess�rio para o teste
    // Cria uma inst�ncia do navegador e abre a p�gina inicial da DevMedia.
    @BeforeClass
    public static void setUpTest(){
    	System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-master\\geckodriver.exe");
    	driver = new FirefoxDriver();
    	//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
    	//driver = new ChromeDriver();  	
    }
 
    // M�todo que finaliza o teste, fechando a inst�ncia do WebDriver.    
    @AfterClass
    public static void tearDownTest(){
        driver.quit();
    }
 
 
    // M�todo que testa simula��o correta do usu�rio.
    @Test
    public void testaSimulacaoCorreta() throws InterruptedException {
    	
    driver.get("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");

 
    // Pegar elemento ValorAplicar
  	WebElement element = driver.findElement(By.name("valorAplicar"));
     
    // Insere dados no elemento "ValorAplicar".
    element.sendKeys("2500");
    
    //Thread.sleep(5000);
    
    // Atribui ao objeto �element� o elemento de atributo "valorInvestir".
    element = driver.findElement(By.name("valorInvestir"));
 
    // Insere dados no elemento "valorInvestir".
    element.sendKeys("2500");
    
    // Atribui ao objeto �element� o elemento de atributo "tempo".
    element = driver.findElement(By.name("tempo"));
 
    // Insere dados no elemento "tempo".
    element.sendKeys("24");
       
    // Clica no bot�o "SIMULA��O" e submete os dados para concluir.
    driver.findElement(By.className("btnSimular")).click();  
  
    //Pegar texto do valor calculado, que deve ser o mesmo j� adicionado no c�digo
    //O valor adicionado no c�digo n�o necess�riamente precisa ser um valor fixo, pode ser
    //uma formula, ou at� mesmo lido de uma tabela de valores, caso necess�rio.
    String valorCalculado = driver.findElement(By.className("valor")).getAttribute("innerText");    
    assertEquals("R$ 649", valorCalculado);    
    }
    
    
 // Teste com valor m�nimo n�o atingido.
    @Test
    public void testaValida��oValorMinimo() throws InterruptedException {
    	//Abrir novamente o site, aqui poderia ser feito um m�todo e chama-lo novamente
    	driver.get("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");

        // Pegar elemento ValorAplicar
      	WebElement element = driver.findElement(By.name("valorAplicar"));
         
        // Insere dados no elemento "ValorAplicar".
        element.sendKeys("1950");
        
        //Thread.sleep(5000);
        
        // Atribui ao objeto �element� o elemento de atributo "valorInvestir".
        element = driver.findElement(By.name("valorInvestir"));
     
        // Insere dados no elemento "valorInvestir".
        element.sendKeys("2500");
        
        // Atribui ao objeto �element� o elemento de atributo "tempo".
        element = driver.findElement(By.name("tempo"));
     
        // Insere dados no elemento "tempo".
        element.sendKeys("24");
           
        // Clica no bot�o "SIMULA��O" e submete os dados para concluir.
        driver.findElement(By.className("btnSimular")).click();  
      
        //Pegar texto do erro e verifica se foi feita a valida��o corretamente
        //O c�digo � o mesmo para outras valida��es da tela, por isso n�o er� replicado
        String ValorErro = driver.findElement(By.id("valorAplicar-error")).getAttribute("innerText");    
        assertEquals("Valor m�nimo de 20.00", ValorErro);    
        }


    // Teste limpar dados do cadastro
       @Test
       public void testaLimparDados() throws InterruptedException {
       	//Abrir novamente o site, aqui poderia ser feito um m�todo e chama-lo novamente
       	driver.get("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");

           // Pegar elemento ValorAplicar
         	WebElement element = driver.findElement(By.name("valorAplicar"));
            
           // Insere dados no elemento "ValorAplicar".
           element.sendKeys("2500");
           
           //Thread.sleep(5000);
           
           // Atribui ao objeto �element� o elemento de atributo "valorInvestir".
           element = driver.findElement(By.name("valorInvestir"));
        
           // Insere dados no elemento "valorInvestir".
           element.sendKeys("2500");
           
           // Atribui ao objeto �element� o elemento de atributo "tempo".
           element = driver.findElement(By.name("tempo"));
        
           // Insere dados no elemento "tempo".
           element.sendKeys("24");
           
           // Clica no bot�o "SIMULA��O" e submete os dados para concluir.
           driver.findElement(By.className("btnLimpar")).click();  
           driver.findElement(By.className("btnSimular")).click();
         
           //Pegar texto do erro e verifica se foi feita a valida��o corretamente
           //O c�digo � o mesmo para outras valida��es da tela, por isso n�o er� replicado
           String ValorErro = driver.findElement(By.id("valorAplicar-error")).getAttribute("innerText");    
           assertEquals("Valor m�nimo de 20.00", ValorErro);  
                      
           }
    
}