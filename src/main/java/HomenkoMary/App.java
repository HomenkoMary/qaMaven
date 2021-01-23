package HomenkoMary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App
{
    private static WebDriver driver;
    private static final String PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String LOGIN = "Applanatest";
    private static final String PASSWORD = "Student2020!";

    public static void main( String[] args ) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");


        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(PAGE_URL);

        WebElement loginInput = driver.findElement(By.name("_username"));
        loginInput.sendKeys(LOGIN);

        WebElement paswordInput = driver.findElement(By.name("_password"));
        paswordInput.sendKeys(PASSWORD);

        WebElement loginButton = driver.findElement(By.name("_submit"));
        loginButton.click();

        Actions action = new Actions(driver);
        WebElement projectMenu = driver.findElement(By.xpath("//div[2]/ul/li[3]/a"));
        action.moveToElement(projectMenu).perform();

        WebElement allProjectMenuItem = driver.findElement(By.xpath("//li[3]/ul/li[4]/a/span"));
        allProjectMenuItem.click();

        WebElement createProjectButton = driver.findElement(By.xpath("//div/a[text()='Создать проект']"));
        createProjectButton.click();

        WebElement nameProjectInput = driver.findElement(By.name("crm_project[name]"));
        nameProjectInput.sendKeys(RandomStringUtils.randomAlphabetic(7, 14));

        WebElement nameOrganisationInput = driver.findElement(By.cssSelector(".select2-default > .select2-arrow"));
        nameOrganisationInput.click();

        WebElement nameOrganisationSelect = driver.findElement(By.cssSelector(".select2-results > .select2-results-dept-0"));
        nameOrganisationSelect.click();

        Thread.sleep(5000);

        Select contactMainSelect = new Select(driver.findElement(By.name("crm_project[contactMain]")));
        contactMainSelect.selectByIndex(1);

        Select curatorSelect = new Select(driver.findElement(By.name("crm_project[curator]")));
        curatorSelect.selectByIndex(1);

        Select businessUnitSelect = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        businessUnitSelect.selectByValue("1");

        Select administratorSelect = new Select(driver.findElement(By.name("crm_project[administrator]")));
        administratorSelect.selectByIndex(3);

        Select projectManagerSelect = new Select(driver.findElement(By.name("crm_project[rp]")));
        projectManagerSelect.selectByIndex(4);

        Select managerSelect = new Select(driver.findElement(By.name("crm_project[manager]")));
        managerSelect.selectByIndex(5);

        WebElement saveProjectButton = driver.findElement(By.cssSelector(".btn-group:nth-child(4) > .btn"));
        saveProjectButton.click();

        driver.quit();

    }
}
