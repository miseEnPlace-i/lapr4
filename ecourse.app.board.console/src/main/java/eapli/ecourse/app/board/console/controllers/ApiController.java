package eapli.ecourse.app.board.console.controllers;

import javax.json.Json;
import javax.json.JsonObject;
import eapli.ecourse.app.board.common.http.Request;
import eapli.ecourse.app.board.common.http.Response;
import eapli.ecourse.app.board.common.http.RouteController;

public class ApiController implements RouteController {
  @Override
  public void handle(Request req, Response res) {
    JsonObject json = Json.createObjectBuilder().add("message", "Hello World!").build();
    res.json(json);
  }
}
