package DDT;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Program010_FetchingDataFromJasonFile 
{
	public static void main(String[] args) throws Throwable 
	{
		//Step 1 : getting the connection of the file
		File fis = new File("./src/test/resources/JsonData2.json");
		
		ObjectMapper object = new ObjectMapper();
		JsonNode data = object.readTree(fis);
		
//		String BROWSER = data.get("browser").asText();
		data.get("browser").asText();
		String URL = data.get("url").asText();
		String USERNAME = data.get("username").asText();
		String PASSWORD = data.get("password").asText();
		
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
	}
}
