package eliseev.framework.contexts;

import eliseev.framework.pages.ClientPage;
import eliseev.framework.pages.OrderPage;
import eliseev.framework.utilities.Waiter;

public class OrderContext {
    private OrderContext(){}
    public static OrderPage order(ClientPage page, String Name, String Surname, String Phone, String email) throws InterruptedException {
        Waiter waiter = new Waiter();
        page.inputNameSurname(Name,Surname);
        Thread.sleep(1000);
        page.inputPhone(Phone);
        page.inputEmail(email);
        Thread.sleep(5000);
        return page.submit();
    }
}