package ua.com.rozetka.pages.main;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by aleksandrap on 7/25/2018
 */
public class CenterBlock {

    SelenideElement itemLaptopsWithSSD;
    SelenideElement firstCompareIcon;
    SelenideElement secondCompareIcon;
    SelenideElement firstLaptop;
    SelenideElement secondLaptop;
    SelenideElement compareThisProductsButton;

    public SelenideElement clickOnLaptopsWithSSD() {

        ElementsCollection elements = $$("a.pab-h4-link");
        for (SelenideElement element : elements) {
            if (element.getText().contains("Ноутбуки с SSD")) {
                itemLaptopsWithSSD = element;
            }
        }
        return itemLaptopsWithSSD;
    }

    public SelenideElement hoverOnFirstLaptop() {

        ElementsCollection elements = $$("div.over-wraper");
        firstLaptop = elements.get(0);
        return firstLaptop;
    }

    public SelenideElement hoverOnSecondLaptop() {

        ElementsCollection elements = $$("div.over-wraper");
        secondLaptop = elements.get(1);
        return secondLaptop;
    }

    public SelenideElement clickOnFirstCompareIcon() {
        ElementsCollection elements = $$("span.g-compare");
        firstCompareIcon = elements.get(0);
        return firstCompareIcon;
    }

    public SelenideElement clickOnSecondCompareIcon() {
        ElementsCollection elements = $$("span.g-compare");
        secondCompareIcon = elements.get(1);
        return secondCompareIcon;
    }

    public SelenideElement clickOnCompareThisProductsButton() {
        ElementsCollection elements = $$("span.btn-link-i");
        for (SelenideElement element : elements) {
            if (element.getText().contains("Сравнить эти товары")) {
                compareThisProductsButton = element;
            }
        }
        return compareThisProductsButton;
    }

    int countOfDifference;
    public int shouldFindDifferencePointsOnPage () {

        ElementsCollection elements = $$("div.comparison-t-row");

        for (SelenideElement element : elements) {

            //пропускаем первую итерацию с картинкой;
            if (element == elements.get(0)) continue;
            List<SelenideElement> row = element.$$("div.comparison-t-cell");

            String firstTextRow = row.get(0).getText();
            String secondTextRow = row.get(1).getText();

            if (!firstTextRow.equalsIgnoreCase(secondTextRow))  {
                countOfDifference++;
            }
        }
        return countOfDifference;
    }

    public SelenideElement getOnlyDifferenceButton () {
        SelenideElement onlyDifferenceButton = $("a.m-tabs-link");
        return onlyDifferenceButton;
    }

    int differenceOnPage;
    public  int onlyDifferenceOnPage() {
        ElementsCollection elements = $$("div.comparison-t-row");
        differenceOnPage = elements.size();
        return  differenceOnPage;
    }
}

