import java.util.List;
import org.sql2o.*;

public class Client {
  private int id;
  private String clientName;
  private int stylistId;

public int getId() {
  return id;
}

public String getClientName() {
  return clientName;
}

public int getStylistId() {
  return stylistId;
}

public Client(String clientName, int stylistId) {
  this.clientName = clientName;
  this.stylistId = stylistId;
}

public static List<Client> all() {
  String sql = "SELECT clientName, stylistId FROM clients";
  try(Connection con = DB.sql2o.open()) {
    return con.createQuery(sql)
      .executeAndFetch(Client.class);
  }
}

@Override
public boolean equals(Object otherClient) {
  if (!(otherClient instanceof Client)) {
    return false;
  } else {
    Client newClient = (Client) otherClient;
    return this.getClientName().equals(newClient.getClientName()) &&
    this.getId() == newClient.getId() &&
    this.getStylistId() == newClient.getStylistId();
  }
}



}
