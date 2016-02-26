import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @ClassRule
  public static ServerRule server = new ServerRule();


  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("whether you're a sheep or a shepherd");
  }

  @Test
  public void stylistIsSavedandDisplayed() {
    goTo("http://localhost:4567/");
    fill("#name").with("Zenbar");
    submit(".btn");
    assertThat(pageSource()).contains("Zenbar");
  }

  @Test
  public void stylistAppearsOnHomePage() {
    Stylist newStylist = new Stylist("grendel");
    newStylist.save();
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("grendel");
  }
  // @Test
  // public void isALeapYear() {
  //   goTo("http://localhost:4567");
  //   fill("#year").with("2004");
  //   submit(".btn");
  //   assertThat(pageSource()).contains("Correct response");
  // }
}
