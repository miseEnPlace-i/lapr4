package eapli.ecourse.app.board.console.presentation.mainmenu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import eapli.framework.presentation.console.AbstractUI;

public class CreatePostItUI extends AbstractUI {
  private static Logger logger = LogManager.getLogger(CreatePostItUI.class);

  // private ShareBoardController ctrl = new ShareBoardController();

  @Override
  protected boolean doShow() {

    // ...

    logger.info("Not Implemented.");

    return false;
  }

  @Override
  public String headline() {
    return "Create Post-It";
  }
}
