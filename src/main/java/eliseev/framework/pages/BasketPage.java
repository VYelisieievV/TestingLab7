package eliseev.framework.pages;

import eliseev.framework.elements.Button;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends Page {
    @FindBy(id = "popup-checkout")
    private Button Order;
    public ClientPage order(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Order.click();
        return new ClientPage();
    }
    public BasketPage(){
        super();
    }
}