
public class ColorConstant {
  public final static String BLACK = "\033[30m";
  public final static String RED = "\033[31m";
  public final static String GREEN = "\033[32m";
  public final static String YELLOW = "\033[33m";
  public final static String BLUE = "\033[34m";
  public final static String PURPLE = "\033[35m";
  public final static String CYAN = "\033[36m";
  public final static String WHITE = "\033[37m";
  public final static String RESET = "\u001B[0m";

  public static void clearConsole() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

}
