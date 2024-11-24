public class IPAddressValidator {

  public static void main(String[] args) {
    String regex =
      "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
      "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
      "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
      "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

    String[] IPs = {"192.168.1.1", "255.255.255.255", "0.0.0.0", "256.100.50.25", "192.168.1", "192.168.1.1.1"};

    for (String item : IPs) {
      if (item.matches(regex)) {
      System.out.println("IP-address successfully");
      } else {
        System.out.println("IP-address failed");
      }
    }
  }
}
