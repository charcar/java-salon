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

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO clients (clientName, stylistId) VALUES (:clientName, :stylistId)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("clientName", this.clientName)
        .addParameter("stylistId", this.stylistId)
        .executeUpdate()
        .getKey();
    }
  }

  public static Client find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients WHERE id=:id";
      Client client = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Client.class);
      return client;
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM clients WHERE id = :id";
      con.createQuery(sql)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public void update(String updateName) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE clients SET clientName = :updateName WHERE id = :id";
      this.clientName = updateName;
      con.createQuery(sql)
        .addParameter("updateName", updateName)
        .addParameter("id", id)
        .executeUpdate();
    }
  }
}
