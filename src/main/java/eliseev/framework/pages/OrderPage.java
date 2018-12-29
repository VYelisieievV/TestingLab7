package eliseev.framework.pages;

import eliseev.framework.elements.Button;
import eliseev.framework.elements.CheckBox;
import eliseev.framework.elements.TextField;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OrderPage extends Page {
    public OrderPage (){
        super();
    }
    @FindBy(xpath = "//*[@id=\"orders\"]/div/div/div[4]/div/div[8]/div/div[2]/input")
    private TextField Surname;
    @FindBy(xpath = "//*[@id=\"orders\"]/div/div/div[4]/div/div[9]/div/div[2]/input")
    private TextField Name;
    @FindBy(xpath = "//*[@id='orders']/div/div/div[2]/div[1]/div[3]/div/div/ul/li[1]/div[2]/div[2]/div[1]/div/div[1]/input")
    private TextField Address;
    @FindBy(xpath = "//*[@id='orders']/div/div/div[3]/div/div[2]/ul/li/label/div/div")
    private List<CheckBox> Pay;
    @FindBy(xpath = "//*[@id='make-order']")
    private Button SubmitButton;
    public OrderPage inputNameAndSurname(String N, String S){
        if(!Name.isDisplayed()||!Surname.isDisplayed())
            return this;
        Name.input(N);
        Surname.input(S);
        return this;
    }
    public OrderPage inputAddress(String address){
        if(!Address.isDisplayed())
            return this;
        Address.input(address);
        return this;
    }
    public OrderPage setPay(String pay){
        for(CheckBox checkbox : Pay){
            if(checkbox.getText().equals(pay))
                checkbox.Select();
        }
        return this;
    }
    public boolean CheckOrder(){
        try {
            shoot();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SubmitButton.isEnabled();
    }
}