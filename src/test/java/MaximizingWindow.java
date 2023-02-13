import com.microsoft.playwright.*;

import java.util.ArrayList;

public class MaximizingWindow {
    public static void main(String[] args) {
        //Saving URL to string variable
        String link = "https://way2automation.com";
        //Creating Playwright instance
        Playwright playwright = Playwright.create();
        //Creating string array list for setArgs in browser
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");
        //Creating new browser with LaunchOptions for chrome browser
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
        //Creating new browser context with property for full screen
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        //Creating new page
        Page page = context.newPage();
        //Navigating to specific URL
        page.navigate(link);
        System.out.println(page.title());

    }
}
