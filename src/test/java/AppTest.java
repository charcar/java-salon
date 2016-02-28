import org.fluentlenium.adapter.FluentTest;

import org.junit.*;

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

  @Test
  public void navigatesToClientsForStylist() {
    Stylist newStylist = new Stylist("Footpaste");
    newStylist.save();
    String stylistPath = String.format("http://localhost:4567/stylists/%d", newStylist.getId());
    goTo(stylistPath);
    assertThat(pageSource()).contains("Footpaste");
  }


}
