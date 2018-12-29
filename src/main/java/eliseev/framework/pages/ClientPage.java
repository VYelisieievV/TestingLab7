package eliseev.framework.pages;

import eliseev.framework.elements.Button;
import eliseev.framework.elements.HtmlLabel;
import eliseev.framework.elements.Link;
import eliseev.framework.elements.TextField;
import eliseev.framework.utilities.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ClientPage extends Page {
    public ClientPage() {
        super();
    }

    @FindBy(xpath = "//*[@id='purchases_block']/div[1]/div[3]/a")
    private Link Basket;
    @FindBy(xpath = "//*[@id='purchases_block']/div[1]/div[1]/div[5]/div[2]")
    private HtmlLabel Price;
    @FindBy(id = "reciever_name")
    private TextField NameSurname;
    @FindBy(id = "suggest_locality")
    private TextField City;
    @FindBy(id = "reciever_phone")
    private TextField Phone;
    @FindBy(id = "reciever_email")
    private TextField Email;
    @FindBy(xpath = "//*[@id='step_contacts']/div/div[1]/div[2]/div/span/button")
    private Button Forward;

    public BasketPage basket() {
        Basket.follow();
        return new BasketPage();
    }

    public String getPrice() {
        return Price.getText();
    }

    public ClientPage inputNameSurname(String Name, String Surname) {
        NameSurname.input(Surname + " " + Name);
        return this;
    }

    public ClientPage inputPhone(String phone) {
        Phone.input(phone);
        return this;
    }

    public ClientPage inputEmail(String email) {
        Email.input(email);
        return this;
    }

    public boolean isEnabled() {
        return Forward.isEnabled();
    }

    public OrderPage submit() {
        Waiter.wait.until(o->{return ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='step_contacts']/div/div[1]/div[2]/div/span/button"));});
        Forward.click();
        System.out.println("clicked");
        return new OrderPage();
    }
}