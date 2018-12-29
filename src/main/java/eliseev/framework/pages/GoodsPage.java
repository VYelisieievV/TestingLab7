package eliseev.framework.pages;

import eliseev.framework.elements.Button;
import org.openqa.selenium.support.FindBy;

public class GoodsPage extends Page {
    @FindBy(xpath = "/html/body/div[4]/div/div[3]/div/div[2]/div/div/div/div[1]/div[2]/div/div/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div/form/span/span/button")
    private Button BuyButton;
    public BasketPage addToBasket(){
        BuyButton.click();
        return  new BasketPage();
    }
    public GoodsPage(){
        super();
    }
}