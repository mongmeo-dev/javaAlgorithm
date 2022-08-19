import java.util.Scanner;

public class P1343 {

  public static void main(String[] args) {
    String map = (new Scanner(System.in)).nextLine();

    // 순서 주의!!
    String result = map.replace("XXXX", "AAAA");
    result = result.replace("XX", "BB");

    if (result.contains("X")) {
      System.out.println(-1);
      return;
    }

    System.out.println(result);
  }

}
