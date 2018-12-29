import eliseev.framework.contexts.BasketContext;
import eliseev.framework.contexts.CheckContext;
import eliseev.framework.contexts.MainContext;
import eliseev.framework.contexts.OrderContext;
import eliseev.framework.drivers.Firefox;
import eliseev.framework.pages.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static org.junit.Assert.fail;

public class RozetkaTest {
    private static String baseUrl = "https://rozetka.com.ua/91456/c91456/";
    private StringBuffer RozetkaErrors = new StringBuffer();

    @Before
    public void setUpTest() throws Exception {
        Firefox.initialize();
        FluentWait wait=new FluentWait(Firefox.getDriver());
        wait.withTimeout(Duration.ofMillis(5000));
        wait.pollingEvery(Duration.ofMillis(500));
    }

    @Test
    public void testRozetka() throws Throwable {
        try {
            Firefox.getDriver().navigate().to(baseUrl);
            Firefox.getDriver().manage().window().maximize();
            Thread.sleep(2000);
            CheckContext.CheckOrder(OrderContext.order(BasketContext.Order(MainContext.ChooseItem(new MainPage(),"Настенные часы Uta 070 VP","Украина",100,2000)),"Валера","Володя","0505553535","valerian-volodemyan@ukr.net"),"Mister","Trickster");

        }
        catch (Exception e){
            RozetkaErrors.append("Something went wrong...");
            e.printStackTrace();}
    }
    @After
    public void tearDown() throws Exception {
        Firefox.shutDown();
        String RozetkaErrorString = RozetkaErrors.toString();
        if (!"".equals(RozetkaErrors.toString())) {
            fail(RozetkaErrorString);
        }
    }
}