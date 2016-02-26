import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Stylist.all().size(), 0);
  }

  @Test
  public void equals_returnsTrueIfNamesofStylistsAreTheSame() {
    Stylist firstStylist = new Stylist("Terrance");
    Stylist secondStylist = new Stylist("Terrance");
    assertTrue(firstStylist.equals(secondStylist));
  }



}
