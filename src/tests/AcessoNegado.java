package tests;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AcessoNegado {

	@Test
	public void test() {

		//abrindo o navegador do googlechrome
		System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://testesoftware1-001-site1.etempurl.com/exercicios/tarefa06");
		
		//maximizando a janela do navegador
		driver.manage().window().maximize();
		
		//preencher o campo nome do usuário
		driver.findElement(By.xpath("//*[@id=\"NomeDeUsuario\"]")).sendKeys("testador");
		
		//preencher o campo senha do usuário
		driver.findElement(By.xpath("//*[@id=\"Senha\"]")).sendKeys("teste123");
		
		//clicar no botão de confirmação
		driver.findElement(By.xpath("//*[@id=\"btnAcesso\"]")).click();
		
		//capturar o texto da mensagem exibida pelo sistema
		String mensagem = driver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();
		
		//verificar o conteúdo da mensagem
		assertEquals(mensagem, "Acesso negado.");
		
		try {
			
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo, new File("Evidência - Acesso negado.png"));	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//fechar o navegador
		driver.close();
	}

}
