package stepslogin;

import static DriverWeb.DriverExe.ativarNavegador;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class StepsDefinition {

	@Dado("que o usuário navegue")
	public void queOUsuárioNavegue() {
		ativarNavegador().get("https://www.amazon.com.br/");

	}

	@After
	public void imagens(Scenario scenario) {
		File screenshot = ((TakesScreenshot) ativarNavegador()).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("dd-MM-yyyy-HHmmss").format(new Date());

		String mensagem;
		if (scenario.isFailed()) {
			mensagem = "Falhou";
		} else {
			mensagem = "Passou";
		}

		try {
			FileUtils.copyFile(screenshot,
					new File("./LoginSimples" + scenario.getName() + "-" + timestamp + "-" + mensagem + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Quando("digite  email e senha")
	public void digiteEmailESenha() throws IOException {
		ativarNavegador().findElement(By.id("nav-link-accountList-nav-line-1")).click();

		String filePath = "./massaDados/Login.xlsx";
		FileInputStream file = new FileInputStream(filePath);
		
		Workbook workbook = new XSSFWorkbook(file);
		Sheet linha = workbook.getSheetAt(0);
		Row row = linha.getRow(1);

		Cell loginCell = row.getCell(0);
		String loginPlanilha = loginCell.getStringCellValue();
		WebElement email = ativarNavegador().findElement(By.id("ap_email"));
		email.sendKeys(loginPlanilha);
		ativarNavegador().findElement(By.id("continue")).click();
		System.out.println(loginCell);

		Cell senhaCell = row.getCell(1);
		String senhaPlanilha = senhaCell.getStringCellValue();
		WebElement passWord = ativarNavegador().findElement(By.id("ap_password"));
		passWord.sendKeys(senhaPlanilha);
		ativarNavegador().findElement(By.id("signInSubmit")).click();
		System.out.println(senhaPlanilha);

	}

	@Então("seguida a mensagem com sucesso")
	public void seguidaAMensagemComSucesso() {
		String validar = ativarNavegador().findElement(By.id("nav-link-accountList-nav-line-1")).getText();
		Assert.assertEquals(ativarNavegador().findElement(By.id("nav-link-accountList-nav-line-1")).getText(), validar);
	}

	@Dado("clicar sair")
	public void clicarSair() {
		WebElement elemento = ativarNavegador().findElement(By.id("nav-link-accountList-nav-line-1"));
		Actions look = new Actions(ativarNavegador());
		look.moveToElement(elemento).build().perform();

		ativarNavegador().findElement(By.xpath("//a[@id='nav-item-signout']//span")).click();
	}

	@Então("a mensagem exibida Saiu")
	public void aMensagemExibidaSaiu() {
		Assert.assertEquals(ativarNavegador().findElement(By.className("a-spacing-small")).getText(), "Fazer login");

	}

}
