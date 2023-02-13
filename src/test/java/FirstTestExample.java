import com.microsoft.playwright.Playwright;

public class FirstTestExample {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        playwright.chromium().launch();
    }
}
