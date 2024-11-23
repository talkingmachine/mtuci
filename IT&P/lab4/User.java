public class User {

  private static String name;
  private static int age;

  public static void setName(String newName) {
    name = newName;
  }

  public static void setAge(int newAge) throws CustomAgeException {
    if (newAge < 0) {
      throw new CustomAgeException("Возраст не может быть меньше 0");
    } else if (newAge > 120) {
      throw new CustomAgeException("Возраст не может быть превышать 120");
    }
    age = newAge;
  }

  public static void main(String[] args) {
    name = "TestUser1";
    age = 21;

    try {
      setAge();
    } catch (CustomAgeException e) {
      System.out.println(e.getMessage());
      ErrorLogger.logException(e);
    }
  }
}
