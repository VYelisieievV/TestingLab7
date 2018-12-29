package eliseev.framework.pages;

import eliseev.framework.drivers.Firefox;
import eliseev.framework.utilities.Decorator;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Page {
    public Page(){
        PageFactory.initElements(new Decorator(Firefox.getDriver()),this);
    }
    public void shoot() throws IOException{
        Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(Firefox.getDriver());
        ImageIO.write(screenshot.getImage(), "PNG", new File("Screenshots\\finale.png"));
   }
    //public static void shoot(WebDriver firefox) {
//
     ///   try {
      //      String targetUrl = firefox.getCurrentUrl();
    //        String targetImg = "results.png";
     //       String command = "/Users/User/phantomjs-2.1.1-windows/bin/phantomjs /Users/User/phantomjs-2.1.1-windows/examples/rasterize.js " + targetUrl + " " + targetImg;
      //      Process p = Runtime.getRuntime().exec(command);
      //      p.waitFor();
     //   } catch (Exception e) {
      //      e.printStackTrace();
      //  }
    //}

}
