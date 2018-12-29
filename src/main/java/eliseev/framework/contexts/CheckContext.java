package eliseev.framework.contexts;
import eliseev.framework.pages.OrderPage;

public class CheckContext {
    private CheckContext(){}
    private static void setParameters(OrderPage page, String Name, String Surname){
        page.inputNameAndSurname(Name,Surname);
    }
    public static void CheckOrder(OrderPage page, String Name, String Surname){
        setParameters(page,Name,Surname);
        System.out.println(page.CheckOrder());
    }
}