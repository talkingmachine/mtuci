public class Main {

  public static void main(String[] args) {
    DataManager dataManager = new DataManager();

    dataManager.registerDataProcessor(new DataFilter());
    dataManager.registerDataProcessor(new DataTransformer());

    dataManager.loadData("source.txt");
    dataManager.processData();
    dataManager.saveData("destination.txt");
  }
}
