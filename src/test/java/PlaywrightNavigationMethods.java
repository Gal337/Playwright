import com.microsoft.playwright.*;

import java.awt.*;
import java.nio.file.Paths;

public class PlaywrightNavigationMethods {
    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        //Saving URL to string variable
        String link = "https://www.way2automation.com/";
        //Creating Playwright instance
        Playwright playwright = Playwright.create();
        //Setting path to SPECIFIC browser with setExecutablePath(Paths.get("ENTER PATH TO BROWSER EXE FILE"))
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        //Command for maximizing the browser window
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize((int)width,(int)height));        //From browser we are creating new page - for using maximized window we need to use the new browser context variable
        Page page = browserContext.newPage();
        //From the page we navigate to any URL of choice
        page.navigate(link);
        //Retrieving the page title
        System.out.println(page.title());
        //Going to previous page
        page.navigate("https://www.google.com");
        page.goBack();
        //Going forward to different page
        page.goForward();
        //Refreshing the page
        page.reload();

    }
}
