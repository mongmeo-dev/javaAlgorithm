import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

public class P1260 {

  static final HashMap<Integer, TreeSet<Integer>> graph = new HashMap<>();
  static int n, m, v;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    v = sc.nextInt();

    // 그래프 저장
    int keyTmp;
    int valueTmp;
    for (int i = 0; i < m; i++) {
      keyTmp = sc.nextInt();
      valueTmp = sc.nextInt();
      if (!graph.containsKey(keyTmp)) {
        graph.put(keyTmp, new TreeSet<>());
      }
      if (!graph.containsKey(valueTmp)) {
        graph.put(valueTmp, new TreeSet<>());
      }
      graph.get(keyTmp).add(valueTmp);
      graph.get(valueTmp).add(keyTmp);
    }

    // 시작 노드와 이어진 노드가 없는 경우
    if (!graph.containsKey(v)) {
      System.out.println(1);
      System.out.println(1);
      return;
    }

    dfs(new HashSet<>(), v, graph.get(v));
    System.out.println();
    bfs();
  }

  public static void dfs(HashSet<Integer> visited, int current, TreeSet<Integer> nexts) {
    if (visited.containsAll(graph.keySet())) {
      return;
    }

    if (!visited.contains(current)) {
      System.out.print(current + " ");
      visited.add(current);

      for (int next : nexts) {
        dfs(visited, next, graph.get(next));
      }
    }
  }

  public static void bfs() {
    Queue<Integer> bQueue = new LinkedList<>();
    HashSet<Integer> visited = new HashSet<>();
    int current;
    bQueue.add(v);

    while (bQueue.size() != 0) {
      current = bQueue.poll();
      bQueue.addAll(graph.get(current));

      if (!visited.contains(current)) {
        System.out.print(current + " ");
        visited.add(current);
      }

      if (visited.containsAll(graph.keySet())) {
        return;
      }
    }
  }
}
