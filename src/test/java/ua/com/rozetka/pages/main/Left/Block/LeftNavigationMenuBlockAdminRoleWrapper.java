package ua.com.rozetka.pages.main.Left.Block;

import ua.com.rozetka.pages.main.LeftNavigationMenuBlock;

/**
 * Created by aleksandrap on 8/4/2018
 */
public class LeftNavigationMenuBlockAdminRoleWrapper  extends LeftNavigationMenuBlock {


    @Override
    public void clickFirstMenuItem(){
        setAdminRole();
        super.clickFirstMenuItem();
    }

    @Override
    public void clickMenuItem(int itemNumber) {
        setAdminRole();
        super.clickMenuItem(itemNumber);
    }

    private void setAdminRole() {

        //some new additional step
    }
}
