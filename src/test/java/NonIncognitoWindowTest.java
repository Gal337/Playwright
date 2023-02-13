import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class NonIncognitoWindowTest {
    public static void main(String[] args) {
        //Saving URL to string variable
        String link = "https://way2automation.com";
        //Creating Playwright instance
        Playwright playwright = Playwright.create();
        //From Playwright instance we need to create browser //Adding new Browser object with headless mode set to false
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        //Use launchPersistentContext with LaunchpersistentContextOptions for running a browser in non-incognito window
        BrowserContext browserContext = playwright.chromium().launchPersistentContext(Paths.get(""), new BrowserType.LaunchPersistentContextOptions().setHeadless(false).setExecutablePath(Paths.get("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe")));
        //From browser we are creating new page - browserContext is used for non-incognito mode in this example
        Page page = browserContext.newPage();
        //From the page we navigate to any URL of choice
        page.navigate(link);
        //Retrieving the page title
        System.out.println(page.title());

    }
}
