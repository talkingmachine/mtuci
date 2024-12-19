import java.util.stream.Collectors;
import java.util.List;

public class DataFilter {

  @DataProcessor
  public List<String> filterData(List<String> data) {
    return data
      .stream()
      .filter(d -> d.contains("1")) // Пример фильтрации
      .collect(Collectors.toList());
  }
}
