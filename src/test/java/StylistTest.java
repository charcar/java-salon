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

  @Test
  public void save_savesStylistIntoDatabase_true() {
    Stylist myStylist = new Stylist("Brian");
    myStylist.save();
    assertTrue(Stylist.all().get(0).equals(myStylist));
  }

  @Test
  public void find_findsStylistInDatabase_true() {
    Stylist myStylist = new Stylist("Romaine");
    myStylist.save();
    Stylist savedStylist = Stylist.find(myStylist.getId());
    assertTrue(myStylist.equals(savedStylist));
  }



}
