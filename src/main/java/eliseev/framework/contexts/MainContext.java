package eliseev.framework.contexts;

import eliseev.framework.pages.GoodsPage;
import eliseev.framework.pages.MainPage;

public class MainContext {
    private MainContext(){}
    private static MainPage filterPrice(MainPage mainpage , int minimal, int maximal) throws InterruptedException {
        mainpage=mainpage.setMaxPrice(maximal);
        mainpage=mainpage.submit();
        Thread.sleep(2000);
        mainpage=mainpage.setMinPrice(minimal);
        mainpage.MaxPrice.sendKeys("");
        return mainpage.submit();

    }
    private static MainPage filterCountry(MainPage mainPage,String country){
        return mainPage.setCountry(country);
    }
    public static GoodsPage ChooseItem(MainPage mainPage, String name, String country, int min, int max) throws InterruptedException {
        Thread.sleep(2000);
        mainPage=filterCountry(filterPrice(mainPage,min,max),country);
        Thread.sleep(2000);
        return mainPage.selectGoodFromGoods(name);
    }
}