package eapli.ecourse.app.common.console.util;

import java.util.Calendar;

import eapli.framework.io.util.Console;

/**
 * Console Constrained Reader utility class.
 *
 * @author André Barros <1211299@isep.ipp.pt>
 */
public final class ConsoleConstrainedReader {
  /**
   * Private constructor to avoid instantiation.
   */
  private ConsoleConstrainedReader() {
  }

  public static String readNonEmptyString(String message) {
    String input = "";
    while (input.isEmpty()) {
      input = Console.readLine("\n" + message);
    }
    return input;
  }

  public static int readNonNegativeInteger(String message) {
    int input = -1;
    while (input < 0) {
      input = Console.readInteger("\n" + message);
      if (input < 0) {
        System.out.println("Invalid input. Please enter a non-negative number.");
      }
    }
    return input;
  }

  public static int readPositiveInteger(String message) {
    int input = -1;
    while (input <= 0) {
      input = Console.readInteger("\n" + message);
      if (input <= 0) {
        System.out.println("Invalid input. Please enter a positive number.");
      }
    }
    return input;
  }

  public static Calendar readNonPastCalendar(String message, String format) {
    Calendar input = null;
    boolean valid = false;
    while (!valid) {
      input = Console.readCalendar("\n" + message, format);
      if (input.after(Calendar.getInstance())) {
        valid = true;
      } else {
        System.out.println("Invalid date. Please enter a date/time in the future.");
      }
    }
    return input;
  }

  public static int readMecanographic(String message) {
    int input = -1;

    while (input < 0 || input > 999999999 || input < 100000000) {
      input = Console.readInteger("\n" + message);
      if (input < 0 || input > 999999999 || input < 100000000) {
        System.out.println("Invalid input. Please enter a mecanographic number with 9 digits.");
      }
    }

    return input;
  }
}
