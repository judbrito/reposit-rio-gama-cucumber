package runners;

import static DriverWeb.DriverExe.ativarNavegador;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/SimplesLogin.feature",
glue = "stepslogin",
plugin = {"pretty", "html:target/reporthtml","json:target/report.json" },
snippets = SnippetType.CAMELCASE, 
monochrome = false,
dryRun = false,
strict = false)
public class NovoLoginTest {
	
	@AfterClass
	public static void fecharPagina() {
		ativarNavegador().quit();
	}
}