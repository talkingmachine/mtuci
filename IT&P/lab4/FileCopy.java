import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

  public static void main(String[] args) {
    String sourceFilePath = "./files/source.txt";
    String destinationFilePath = "./files/destination.txt";

    FileInputStream fis = null;
    FileOutputStream fos = null;

    try {
      File sourceFile = new File(sourceFilePath);
      File destinationFile = new File(destinationFilePath);

      if (!sourceFile.exists()) {
        throw new IOException("The source file does not exist: " + sourceFilePath);
      }

      fis = new FileInputStream(sourceFile);
      fos = new FileOutputStream(destinationFile);

      byte[] buffer = new byte[1024];
      int bytesRead;

      while ((bytesRead = fis.read(buffer)) != -1) {
        fos.write(buffer, 0, bytesRead);
      }

      System.out.println("Копирование завершено");
    } catch (IOException e) {
      System.out.println("Ошибка при работе с файлами: " + e.getMessage());
      ErrorLogger.logException(e);
    } finally {
      try {
        if (fis != null) {
          fis.close();
        }
        if (fos != null) {
          fos.close();
        }
      } catch (IOException e) {
        System.out.println("Error closing files: " + e.getMessage());
        ErrorLogger.logException(e);
      }
    }
  }
}
