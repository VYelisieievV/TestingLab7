package eliseev.framework.pages;

import eliseev.framework.elements.Button;
import eliseev.framework.elements.Link;
import eliseev.framework.elements.TextField;
import eliseev.framework.utilities.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPage extends Page {
    @FindBy(id = "price[min]")
    public TextField MinPrice;
    @FindBy(id="price[max]")
    public TextField MaxPrice;
    @FindBy(id = "submitprice")
    public Button OkButton;
    @FindBy(xpath = "//*[@id='sort_strana-proizvoditelj-tovara-103660_']/descendant::a")
    private List<Link> Country;
    @FindBy(xpath = "//*[@id=\"catalog_goods_block\"]/div/div/div[1]/div/div/div/div[3]/a")
    private List<Link> Goods;
    @FindBy(xpath = "/html/body/div[4]/div/div[3]/div[2]/div/div/div/form/div[9]/div[2]/a[1]")
    private Link More;
    @FindBy(xpath = "//*[@id=\"catalog_goods_block\"]/div/div/div[1]/div/div/div/div/div/descendant::button")
    private List<Button> buttons;
    public MainPage(){
        super();
    }
    public int getMinPrice(){
        return Integer.parseInt(MinPrice.getText());
    }
    public MainPage setMinPrice(int price){
        MinPrice.clear();
        MinPrice.input(Integer.toString(price));
        return this;
    }
    public MainPage setMaxPrice(int price){
        MaxPrice.clear();
        MaxPrice.input(Integer.toString(price));
        return this;
    }
    public MainPage setCountry(String country){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        More.follow();
        Waiter.wait.until(o->{return ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"catalog_goods_block\"]/div/div/div[1]/div/div/div/div[3]/a"));});
        for(Link link : Country){
            if(link.findElement(By.xpath("span/i")).getText().equals(country)) {
                link.follow();
                break;
            }
        }
        return this;
    }
    public GoodsPage selectGoodFromGoods(String name){
        for(Link link : Goods){
            System.out.println(link.getText());
            if(link.getText().equals(name)) {
                System.out.println(link.getText());
                link.follow();
                break;
            }
        }
        return new GoodsPage();
    }
    public MainPage submit(){
        OkButton.click();
        return this;
    }
}