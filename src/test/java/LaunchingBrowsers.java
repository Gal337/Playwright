import com.microsoft.playwright.*;

import java.awt.*;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LaunchingBrowsers {
    public static void main(String[] args) {
        //Getting the width and height of screen resolution (for browserContext)
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        //Printing the width and height of screen resolution
        System.out.println(width + " --- " + height);
        //Saving URL to string variable
        String link = "https://www.way2automation.com/";
        //Creating Playwright instance
        Playwright playwright = Playwright.create();
        //Setting path to SPECIFIC browser with setExecutablePath(Paths.get("ENTER PATH TO BROWSER EXE FILE"))
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setExecutablePath(Paths.get("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe")));
        //Command for maximizing the browser window
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize((int)width,(int)height));
        //From browser we are creating new page - for using maximized window we need to use the new browser context variable
        Page page = browserContext.newPage();
        //From the page we navigate to any URL of choice
        page.navigate(link);
        //Retrieving the page title
        System.out.println(page.title());

    }
}
