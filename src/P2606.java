import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class P2606 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int com = sc.nextInt();
    int net = sc.nextInt();
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Queue<Integer> bfs = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    List<Integer> tmp;
    int key, value;
    int current;
    int answer = -1;

    for (int i = 0; i < net; i++) {
      key = sc.nextInt();
      value = sc.nextInt();

      tmp = graph.getOrDefault(key, new ArrayList<>());
      tmp.add(value);
      graph.put(key, tmp);
      tmp = graph.getOrDefault(value, new ArrayList<>());
      tmp.add(key);
      graph.put(value, tmp);
    }

    bfs.add(1);
    while (!bfs.isEmpty()) {
      current = bfs.poll();

      if (visited.contains(current)) {
        continue;
      }

      visited.add(current);
      bfs.addAll(graph.get(current));
      answer ++;
    }

    System.out.println(answer);
  }
}
