import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("stylists", Stylist.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView (model, layout);
    }, new VelocityTemplateEngine());

    post("/success", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String stylistName = request.queryParams("name");
      Stylist newStylist = new Stylist(stylistName);
      newStylist.save();
      model.put("stylist", newStylist);
      model.put("template", "templates/success.vtl");
      return new ModelAndView (model, layout);
    }, new VelocityTemplateEngine());


    get("/stylists/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("clients", Client.all());
      model.put("stylist", Stylist.find(Integer.parseInt(request.params(":id"))));
      model.put("template", "templates/clients.vtl");
      return new ModelAndView (model, layout);
    }, new VelocityTemplateEngine());

    post("/success/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String clientName = request.queryParams("clientName");
      Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
      Client newClient = new Client(clientName, stylist.getId());
      newClient.save();
      model.put("client", newClient);

      model.put("template", "templates/success.vtl");
      return new ModelAndView (model, layout);
    }, new VelocityTemplateEngine());

    get("/clients/delete/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Client client = Client.find(Integer.parseInt(request.params(":id")));
      client.delete();
      model.put("client", client);
      model.put("template", "templates/deleted.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/delete/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
      model.put("stylist", stylist);
      stylist.delete();
      stylist.deleteClients();
      model.put("template", "templates/deleted.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/client/:clientId/update", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Client client = Client.find(Integer.parseInt(request.params(":clientId")));
      model.put("client", client);
      model.put("template", "templates/updateClient.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/client/:clientId/updated", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Client client = Client.find(Integer.parseInt(request.params(":clientId")));
      String newName = request.queryParams("update");
      client.update(newName);
      model.put("client", client);
      model.put("template", "templates/updated.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylist/:stylistId/update", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Stylist stylist = Stylist.find(Integer.parseInt(request.params(":stylistId")));
      model.put("stylist", stylist);
      model.put("template", "templates/updateStylist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylist/:stylistId/updated", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Stylist stylist = Stylist.find(Integer.parseInt(request.params(":stylistId")));
      String newName = request.queryParams("update");
      stylist.update(newName);
      model.put("stylist", stylist);
      model.put("template", "templates/updated.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


  }
}
