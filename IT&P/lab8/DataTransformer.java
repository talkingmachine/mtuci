import java.util.stream.Collectors;
import java.util.List;

public class DataTransformer {

  @DataProcessor
  public List<String> transformData(List<String> data) {
    return data
      .stream()
      .map(String::toUpperCase) // Пример трансформации
      .collect(Collectors.toList());
  }
}
