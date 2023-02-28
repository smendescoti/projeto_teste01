package tests;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutenticarUsuarioComSucesso {

	@Test
	public void test() {
		
		//Abrindo o navegador do googlechrome
		System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://testesoftware1-001-site1.etempurl.com/exercicios/tarefa06");
		
		//maximizar o navegador
		driver.manage().window().maximize();
		
		//preencher o nome do usuário
		driver.findElement(By.xpath("//*[@id=\"NomeDeUsuario\"]")).sendKeys("administrador");
		
		//preencher a senha do usuário
		driver.findElement(By.xpath("//*[@id=\"Senha\"]")).sendKeys("adminadmin");
		
		//clicar no botão de confirmação
		driver.findElement(By.xpath("//*[@id=\"btnAcesso\"]")).click();
		
		//capturar o texto exibido após a autenticação do usuário
		String mensagem = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/div[2]")).getText();
		
		//verificando se o texto exibido contem a mensagem abaixo
		assertTrue(mensagem.contains("Usuário autenticado"));
		
		try {
			
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo, new File("Evidência - Autenticar usuário com sucesso.png"));	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//fechar o navegador
		driver.close();
	}

}
