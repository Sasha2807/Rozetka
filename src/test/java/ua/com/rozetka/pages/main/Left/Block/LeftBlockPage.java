package ua.com.rozetka.pages.main.Left.Block;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.sun.istack.internal.logging.Logger;
import ua.com.rozetka.pages.main.LeftNavigationMenuBlock;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by aleksandrap on 8/4/2018
 */
public class LeftBlockPage {

    LeftNavigationMenuBlock leftNavigationMenuBlock = new LeftNavigationMenuBlock();

    public void setLeftNavigationMenuBlock(LeftNavigationMenuBlock leftNavigationMenuBlock)   {
        this.leftNavigationMenuBlock = leftNavigationMenuBlock;
    }

    public LeftNavigationMenuBlock getLeftNavigationMenuBlock() {

       // Logger log = Logger.getLogger("Log");
      //  log.info("getLeftNavigationMenuBlock");

        return leftNavigationMenuBlock;
    }


    public SelenideElement getHeader() {

        return $("a#fat_menu_btn").shouldBe(Condition.visible);

    }
}
