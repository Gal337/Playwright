import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FirstTestExample {
    public static void main(String[] args) {
        String link = "https://way2automation.com";
        //Creating Playwright instance
        Playwright playwright = Playwright.create();
        //From Playwright instance we need to create browser //Adding new Browser object with headless mode set to false
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        //From browser we are creating new page
        Page page = browser.newPage();
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
