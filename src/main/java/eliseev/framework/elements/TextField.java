package eliseev.framework.elements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TextField extends Element {

    public TextField(WebElement element) {
        super(element);
    }

    public void input(String s) {

            sendKeys(Keys.CONTROL + "a");
            sendKeys(Keys.DELETE);
            sendKeys(s);

    }
}