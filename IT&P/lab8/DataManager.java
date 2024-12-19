import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class DataManager {

  private final List<Object> processors = new ArrayList<>();
  private List<String> data;

  public void registerDataProcessor(Object processor) {
    processors.add(processor);
  }

  public void loadData(String source) {
    List<String> loadedData = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(source))) {
      String line;
      while ((line = br.readLine()) != null) {
        loadedData.add(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    data = loadedData;
  }

  public void processData() {
    ExecutorService executor = Executors.newFixedThreadPool(processors.size());
    AtomicReference<List<String>> processedData = new AtomicReference<>(data);

    for (Object processor : processors) {
      executor.submit(() -> {
        Method[] methods = processor.getClass().getDeclaredMethods();
        for (Method method : methods) {
          if (method.isAnnotationPresent(DataProcessor.class)) {
            try {
              @SuppressWarnings("unchecked")
              List<String> result = (List<String>) method.invoke(processor, processedData.get());
              processedData.set(result);
            } catch (Exception e) {
              e.printStackTrace();
            }
          }
        }
      });
    }

    executor.shutdown();
    while (!executor.isTerminated()) {
    }

    data = processedData.get();
  }

  public void saveData(String destination) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(destination))) {
      for (String line : data) {
        bw.write(line);
        bw.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
