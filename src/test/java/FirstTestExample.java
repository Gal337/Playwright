import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FirstTestExample {
    public static void main(String[] args) {
        //Creating Playwright instance
        Playwright playwright = Playwright.create();
        //From Playwright instance we need to create browser
        Browser browser = playwright.chromium().launch();
        //From browser we are creating new page
        Page page = browser.newPage();
        //From the page we navigate to any URL of choice

    }
}
