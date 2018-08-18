package ua.com.rozetka.pages.main;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by aleksandrap on 7/25/2018
 */
public class LeftNavigationMenuBlock {

    SelenideElement itemLaptopsAndComputers;
    SelenideElement itemLaptops;

    public void clickFirstMenuItem() {
        this.clickMenuItem(1);
    }

    public void clickMenuItem(int itemNumber) {
    }


    public SelenideElement hoverOnLaptopsAndComputers() {

        ElementsCollection elements = $$("a.f-menu-l-i-link");
        for (SelenideElement element : elements) {
            if (element.getText().contains("Ноутбуки и компьютеры")) {
                itemLaptopsAndComputers = element;
            }
        }
        return itemLaptopsAndComputers;
    }

    public SelenideElement clickOnLaptopsItem() throws IndexOutOfBoundsException {

        ElementsCollection elements = $$("a.f-menu-sub-title-link");
        for (SelenideElement element : elements) {
            if (element.getText().contains("Ноутбуки")) {
                itemLaptops = element;
            }
        }
        return  itemLaptops;
    }
}
