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
 
// Classe JUnit que contém os métodos de teste.
public class TestSicredi {
 
    // Declarando um objeto do tipo WebDriver, utilizado pelo Selenium WebDriver.
    private static WebDriver driver;
 
    // Método que inicia tudo que for necessário para o teste
    // Cria uma instância do navegador e abre a página inicial da DevMedia.
    @BeforeClass
    public static void setUpTest(){
    	System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-master\\geckodriver.exe");
    	driver = new FirefoxDriver();
    	//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
    	//driver = new ChromeDriver();  	
    }
 
    // Método que finaliza o teste, fechando a instância do WebDriver.    
    @AfterClass
    public static void tearDownTest(){
        driver.quit();
    }
 
 
    // Método que testa simulação correta do usuário.
    @Test
    public void testaSimulacaoCorreta() throws InterruptedException {
    	
    driver.get("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");

 
    // Pegar elemento ValorAplicar
  	WebElement element = driver.findElement(By.name("valorAplicar"));
     
    // Insere dados no elemento "ValorAplicar".
    element.sendKeys("2500");
    
    //Thread.sleep(5000);
    
    // Atribui ao objeto “element” o elemento de atributo "valorInvestir".
    element = driver.findElement(By.name("valorInvestir"));
 
    // Insere dados no elemento "valorInvestir".
    element.sendKeys("2500");
    
    // Atribui ao objeto “element” o elemento de atributo "tempo".
    element = driver.findElement(By.name("tempo"));
 
    // Insere dados no elemento "tempo".
    element.sendKeys("24");
       
    // Clica no botão "SIMULAÇÃO" e submete os dados para concluir.
    driver.findElement(By.className("btnSimular")).click();  
  
    //Pegar texto do valor calculado, que deve ser o mesmo já adicionado no código
    //O valor adicionado no código não necessáriamente precisa ser um valor fixo, pode ser
    //uma formula, ou até mesmo lido de uma tabela de valores, caso necessário.
    String valorCalculado = driver.findElement(By.className("valor")).getAttribute("innerText");    
    assertEquals("R$ 649", valorCalculado);    
    }
    
    
 // Teste com valor mínimo não atingido.
    @Test
    public void testaValidaçãoValorMinimo() throws InterruptedException {
    	//Abrir novamente o site, aqui poderia ser feito um método e chama-lo novamente
    	driver.get("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");

        // Pegar elemento ValorAplicar
      	WebElement element = driver.findElement(By.name("valorAplicar"));
         
        // Insere dados no elemento "ValorAplicar".
        element.sendKeys("1950");
        
        //Thread.sleep(5000);
        
        // Atribui ao objeto “element” o elemento de atributo "valorInvestir".
        element = driver.findElement(By.name("valorInvestir"));
     
        // Insere dados no elemento "valorInvestir".
        element.sendKeys("2500");
        
        // Atribui ao objeto “element” o elemento de atributo "tempo".
        element = driver.findElement(By.name("tempo"));
     
        // Insere dados no elemento "tempo".
        element.sendKeys("24");
           
        // Clica no botão "SIMULAÇÃO" e submete os dados para concluir.
        driver.findElement(By.className("btnSimular")).click();  
      
        //Pegar texto do erro e verifica se foi feita a validação corretamente
        //O código é o mesmo para outras validações da tela, por isso não erá replicado
        String ValorErro = driver.findElement(By.id("valorAplicar-error")).getAttribute("innerText");    
        assertEquals("Valor mínimo de 20.00", ValorErro);    
        }


    // Teste limpar dados do cadastro
       @Test
       public void testaLimparDados() throws InterruptedException {
       	//Abrir novamente o site, aqui poderia ser feito um método e chama-lo novamente
       	driver.get("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");

           // Pegar elemento ValorAplicar
         	WebElement element = driver.findElement(By.name("valorAplicar"));
            
           // Insere dados no elemento "ValorAplicar".
           element.sendKeys("2500");
           
           //Thread.sleep(5000);
           
           // Atribui ao objeto “element” o elemento de atributo "valorInvestir".
           element = driver.findElement(By.name("valorInvestir"));
        
           // Insere dados no elemento "valorInvestir".
           element.sendKeys("2500");
           
           // Atribui ao objeto “element” o elemento de atributo "tempo".
           element = driver.findElement(By.name("tempo"));
        
           // Insere dados no elemento "tempo".
           element.sendKeys("24");
           
           // Clica no botão "SIMULAÇÃO" e submete os dados para concluir.
           driver.findElement(By.className("btnLimpar")).click();  
           driver.findElement(By.className("btnSimular")).click();
         
           //Pegar texto do erro e verifica se foi feita a validação corretamente
           //O código é o mesmo para outras validações da tela, por isso não erá replicado
           String ValorErro = driver.findElement(By.id("valorAplicar-error")).getAttribute("innerText");    
           assertEquals("Valor mínimo de 20.00", ValorErro);  
                      
           }
    
}