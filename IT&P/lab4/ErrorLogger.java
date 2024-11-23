import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ErrorLogger {

  private static final String LOG_FILE_PATH = "./logs/error.txt";

  public static void logException(Exception e) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE_PATH, true))) {
      writer.write(e.toString());
      writer.newLine();
      for (StackTraceElement element : e.getStackTrace()) {
        writer.write("\tat " + element.toString());
        writer.newLine();
      }
      writer.newLine();
    } catch (IOException ioException) {
      System.out.println("Ошибка при логировании: " + ioException.getMessage());
    }
  }
}
