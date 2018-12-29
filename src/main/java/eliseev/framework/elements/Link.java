package eliseev.framework.elements;

import org.openqa.selenium.WebElement;

public class Link extends Element {
    public Link(WebElement element) {
        super(element);
    }

    public void follow() {
        if (super.isEnabled() && super.isDisplayed())
            click();
    }
}