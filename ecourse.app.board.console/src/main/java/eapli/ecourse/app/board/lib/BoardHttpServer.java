package eapli.ecourse.app.board.lib;

import eapli.ecourse.app.board.controllers.ApiController;
import eapli.ecourse.app.board.controllers.GetSessionController;
import eapli.ecourse.app.board.controllers.ViewBoardController;
import eapli.ecourse.common.board.HttpServer;
import eapli.ecourse.common.board.http.Router;
import eapli.ecourse.common.board.http.StaticMiddleware;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;

public class BoardHttpServer {
  private static final int HTTP_SERVER_PORT = 8080;
  private static final String WWW_PATH = "www/src";

  public static void run() {
    // create the router
    Router router = new Router();

    // retrieve static files middleware
    router.use(new StaticMiddleware(WWW_PATH));

    // add your routes here
    router.get("/api", new ApiController());

    router.get("/api/session", new GetSessionController());
    router.get("/api/board", new ViewBoardController(PersistenceContext.repositories().boards()));

    // create the http server
    HttpServer httpServer = new HttpServer(HTTP_SERVER_PORT, router);
    Thread httpServerThread = new Thread(httpServer);

    httpServerThread.start();
  }
}
