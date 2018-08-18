package ua.com.rozetka.tests;

import org.junit.Test;
import ua.com.rozetka.pages.main.Left.Block.LeftNavigationMenuBlockAdminRoleWrapper;
import ua.com.rozetka.pages.main.MainPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aleksandrap on 8/4/2018
 */
public class MainPageAsAdminRoleTests {

    private static MainPage page = new MainPage();

   // private List<String> list = new ArrayList<String>(10);

     {
        page.getLeftBlockPage().setLeftNavigationMenuBlock(new LeftNavigationMenuBlockAdminRoleWrapper());
    }


   // public void method(){
       // list.add("String");
  //  }


    @Test
    public void test() {

        page.getLeftBlockPage().getLeftNavigationMenuBlock().clickFirstMenuItem();
    }
}
