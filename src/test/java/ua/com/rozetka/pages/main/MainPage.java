package ua.com.rozetka.pages.main;

import ua.com.rozetka.pages.main.HeaderBlock.HeaderBlock;
import ua.com.rozetka.pages.main.Left.Block.LeftBlockPage;

/**
 * Created by aleksandrap on 7/25/2018
 */
public class MainPage {
    private HeaderBlock header = new HeaderBlock();
    private LeftBlockPage leftBlockPage = new LeftBlockPage();
    private CenterBlock centralBlock = new CenterBlock();


    public HeaderBlock getHeaderBlock() {
        return header;
    }

    public LeftBlockPage getLeftBlockPage() {
        return leftBlockPage;
    }

    public CenterBlock getCentralBlock() {
        return centralBlock;
    }
}
