package eliseev.framework.contexts;

import eliseev.framework.pages.BasketPage;
import eliseev.framework.pages.ClientPage;
import eliseev.framework.pages.GoodsPage;

public class BasketContext {
    private BasketContext(){}
    private static ClientPage MakeOrder(BasketPage page)throws InterruptedException{
        return page.order();
    }
    public static ClientPage Order(GoodsPage page) throws InterruptedException {
        Thread.sleep(1000);
        return MakeOrder(page.addToBasket());
    }
}