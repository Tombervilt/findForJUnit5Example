import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FindJUnit5CodeExample {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void testFindJUnit5CodeExample() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("soft");
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();
        $$(".markdown-heading").findBy(text("JUnit5")).sibling(0)
                 .shouldHave(text("""
                         @ExtendWith({SoftAssertsExtension.class})
                         class Tests {
                         @Test
                         void test() {
                         Configuration.assertionMode = SOFT;
                         open("page.html");
                         $("#first").should(visible).click();
                         $("#second").should(visible).click();
                         }
                         }"""));

        sleep(3000);
    }
}
