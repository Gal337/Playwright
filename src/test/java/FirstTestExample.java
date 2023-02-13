import com.microsoft.playwright.*;

import java.awt.*;

public class FirstTestExample {
    public static void main(String[] args) {
        //Getting the width and height of screen resolution (for browserContext)
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        //Printing the width and height of screen resolution
        System.out.println(width + " --- " + height);
        //Saving URL to string variable
        String link = "https://way2automation.com";
        //Creating Playwright instance
        Playwright playwright = Playwright.create();
        //From Playwright instance we need to create browser //Adding new Browser object with headless mode set to false
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        //Command for maximizing the browser window
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920,1080));
        //From browser we are creating new page - for using maximized window we need to use the new browser context variable
        Page page = browserContext.newPage();
        //From the page we navigate to any URL of choice
        page.navigate(link);
        //Retrieving the page title
        System.out.println(page.title());
        //Closing the page
        page.close();
        //Closing the session
        playwright.close();
    }
}
