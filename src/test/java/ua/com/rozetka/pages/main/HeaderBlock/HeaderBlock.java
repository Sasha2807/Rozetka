package ua.com.rozetka.pages.main.HeaderBlock;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by aleksandrap on 7/25/2018
 */
public class HeaderBlock {
    private WebElement logo;
    private WebElement contactInfo;
    private WebElement langToggle;
    private List<WebElement> headerTopMenuItems;
    private String cityRef = "a.header-city-select-link";
    private String cityChoosePopUp = "div.header-city-choose-popup";

    SelenideElement headCompareButton;

    public void setHeaderTopMenuItems(List<WebElement> items) {
        this.headerTopMenuItems = items;
    }

    public String getCityRef() {
        return cityRef;
    }

    public String getCityChoosePopUp() {
        return cityChoosePopUp;
    }

    public SelenideElement clickOnHeadCompareButton() {

        ElementsCollection elements = $$("a.hub-i-link");
        for (SelenideElement element : elements) {
            if (element.getText().contains("Сравнение")) {
                headCompareButton = element;
            }
        }
        return headCompareButton;
    }
}
