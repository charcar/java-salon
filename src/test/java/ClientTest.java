import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class ClientTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void all_emptyAtFirst() {
    assertEquals(0, Client.all().size());
  }

  @Test
  public void equals_returnsTrueIfDescriptionsAreTheSame() {
    Client firstClient = new Client("Sam", 1);
    Client secondClient = new Client("Sam", 1);
    assertTrue(firstClient.equals(secondClient));
  }

  @Test
  public void save_returnsTrueIfClientNamesAreTheSame() {
    Client myClient = new Client("Sam", 1);
    myClient.save();
    assertTrue((Client.all().get(0).getClientName()).equals(myClient.getClientName()));
  }

  @Test
  public void save_assignsStylistIdToObject() {
    Client myClient = new Client("Same", 1);
    myClient.save();
    Client savedClient = Client.all().get(0);
    assertEquals(myClient.getStylistId(), savedClient.getStylistId());
  }


}
