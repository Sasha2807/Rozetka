package ua.com.rozetka.tests;

import com.codeborne.selenide.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ua.com.rozetka.pages.main.Left.Block.LeftNavigationMenuBlockAdminRoleWrapper;
import ua.com.rozetka.pages.main.MainPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.*;
import static com.sun.activation.registries.LogSupport.log;

/**
 * Created by aleksandrap on 7/25/2018
 */
public class MainPageTests {

    private static WebDriver driver;
    //Properties config
    private static InputStream file;
    private static Properties config = new Properties();
    private static String siteAddress;
    private MainPage page = new MainPage();

    @BeforeClass
    public static void setUp() throws IOException {

        file = new FileInputStream("src/test/java/ua/com/rozetka/config/config.properties");
        config.load(file);
        siteAddress = config.getProperty("site.address");

        System.setProperty("webdriver.chrome.driver", "C://chromedriver//chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");

        open(siteAddress);


        // driver = new ChromeDriver();
        // driver.manage().window().maximize();
    }

    /*
    @Test
    public void shouldAppearCityPopUpOnCityRefClick()throws InterruptedException{
        //given
        driver.get(siteAddress);
        String cityRef = page.getHeader().getCityRef();
        WebElement cityRefElem = driver.findElement(By.cssSelector(cityRef));

        //when
        Thread.sleep(5000);
        cityRefElem.click();

        //then
        String cityChoosePopUp = page.getHeader().getCityChoosePopUp();
        WebElement popUpElem = driver.findElement(By.cssSelector(cityChoosePopUp));

        Assert.assertTrue("Блок с названиями городов не появился!",
                popUpElem.isDisplayed());
    }
*/
    @Test
    public void headerTest() {
        $("input.rz-header-search-input-text").shouldBe(Condition.visible);
        $("input.rz-header-search-input-text").setValue("Lenovo");
        sleep(5000);
        $("div.rz-header-search-suggest-g").shouldBe(Condition.appear);

        ElementsCollection menuItems = $$("div.rz-header-search-suggest-i");

        for (SelenideElement item : menuItems) {

            item = menuItems.get(5);
            item.getText().contains("Мобильные телефоны");
            item.click();
            break;
        }
        sleep(5000);
    }
/*

    @Test
    public void headerTest1() {

        SelenideElement searchField = page.getHeader().getSearch().getTextField();
        SelenideElament searchOkbutton = page.getHeader().getSearch().getOkButton();

        searchField.setValue("Lenovo");
        searchOkbutton.click();

        searchResultPage.shouldBe(Condition.exist);
    }
    */

    @Test
    public void leftBlockHeaderTest(){

        sleep(5000);

        //when
        String headerText = page.getLeftBlockPage().getHeader().getText();
        //then

        if(headerText!=null) {

            Assert.assertEquals("Каталог товаров", headerText);
        }
    }

    @Test
    public void testLeftBlockAsAdmin() {
        //given
        page.getLeftBlockPage().setLeftNavigationMenuBlock(new LeftNavigationMenuBlockAdminRoleWrapper());

        //when
        page.getLeftBlockPage().getLeftNavigationMenuBlock().clickMenuItem(10);

        //then
        $("div.f-menu-cols-b").shouldBe(Condition.exist);
    }

    @Test
    public void testVerifyDifferenceBetweenTwoProducts() {
        //given
        //log("Hover on 'Laptops and Computers' item");
        page.getLeftBlockPage().getLeftNavigationMenuBlock().hoverOnLaptopsAndComputers().hover();
        sleep(5000);

        //log("Click on 'Laptops' category");
        page.getLeftBlockPage().getLeftNavigationMenuBlock().clickOnLaptopsItem().shouldBe(Condition.visible);
        page.getLeftBlockPage().getLeftNavigationMenuBlock().clickOnLaptopsItem().click();
        sleep(5000);

        //log("Click on 'Ноутбуки с SSD'");
        page.getCentralBlock().clickOnLaptopsWithSSD().shouldBe(Condition.visible);
        page.getCentralBlock().clickOnLaptopsWithSSD().click();
        sleep(5000);

        //log("Click on first compare icons");
        page.getCentralBlock().hoverOnFirstLaptop().shouldBe(Condition.visible);
        page.getCentralBlock().hoverOnFirstLaptop().click();
        sleep(5000);
        page.getCentralBlock().clickOnFirstCompareIcon().shouldBe(Condition.visible);
        page.getCentralBlock().clickOnFirstCompareIcon().click();
        sleep(5000);

        //log("Click on second compare icons");
        page.getCentralBlock().hoverOnSecondLaptop().shouldBe(Condition.visible);
        page.getCentralBlock().hoverOnSecondLaptop().click();
        sleep(5000);
        page.getCentralBlock().clickOnSecondCompareIcon().shouldBe(Condition.visible);
        page.getCentralBlock().clickOnSecondCompareIcon().click();
        sleep(5000);

        //log("Click on 'Сравнение' button");
        page.getHeaderBlock().clickOnHeadCompareButton().should(Condition.visible);
        page.getHeaderBlock().clickOnHeadCompareButton().click();
        sleep(5000);

        //log("Click on 'Сравнить эти товары'");
        page.getCentralBlock().clickOnCompareThisProductsButton().shouldBe(Condition.visible);
        page.getCentralBlock().clickOnCompareThisProductsButton().click();
        sleep(3000);

        //log("Count differences on first tab");
        int dif = page.getCentralBlock().shouldFindDifferencePointsOnPage();
        sleep(3000);
        page.getCentralBlock().getOnlyDifferenceButton().click();
        sleep(3000);
        int differenceOnPage = page.getCentralBlock().onlyDifferenceOnPage();
        sleep(3000);
        Assert.assertEquals("количество обнаруженных отличий не равно значению на сайте",
                differenceOnPage, dif);
    }
}
