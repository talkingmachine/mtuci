import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TopTenWords {

  public static void main(String[] args) {
    String filePath = "./file.txt";
    File file = new File(filePath);
    Scanner scanner = null;
    try {
      scanner = new Scanner(file);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return;
    }

    Map<String, Integer> wordCountMap = new HashMap<>();

    while (scanner.hasNext()) {
      String word = scanner.next().toLowerCase().replaceAll("[^a-zA-Z]", "");
      if (!word.isEmpty()) {
        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
      }
    }

    scanner.close();

    List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCountMap.entrySet());

    list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

    System.out.println("Топ 10 самых популярных слов:");
    for (int i = 0; i < Math.min(10, list.size()); i++) {
      System.out.println(list.get(i).getKey() + ": " + list.get(i).getValue());
    }
  }
}
