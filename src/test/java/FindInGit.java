import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class FindInGit{
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }
    @Test
    void successfulSearchTest() {
        open("https://github.com/");
        $(withText("Search or jump")).click();
        actions().sendKeys(Keys.chord("selenide", Keys.ENTER)). perform();
        $(".Box-sc-g0xbh4-0.bBwPjs").click();
        $("[href='/selenide/selenide/wiki']").click();
        $(withText("Show 3 more pages")).click();
        $("div.wiki-rightbar").$(byText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text("""
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");
                                
                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }
                """)).shouldBe(visible);





    }
}
