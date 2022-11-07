import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P7568 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();

    List<Input> inputs = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      String[] splitInput = sc.nextLine().split(" ");
      inputs.add(new Input(Integer.parseInt(splitInput[0]), Integer.parseInt(splitInput[1])));
    }

    for (Input input : inputs) {
      long rank = inputs.stream()
          .filter(other -> input.getHeight() < other.getHeight()
              && input.getWeight() < other.getWeight())
          .count() + 1;
      System.out.println(rank);
    }
  }

  static class Input {

    int height;
    int weight;

    public Input(int height, int weight) {
      this.height = height;
      this.weight = weight;
    }

    public int getHeight() {
      return height;
    }

    public int getWeight() {
      return weight;
    }
  }
}
