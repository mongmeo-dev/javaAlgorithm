import java.util.Arrays;
import java.util.Scanner;

public class P2839 {

  public static void main(String[] args) {
    int NO_VALUE = 5000;
    Scanner sc = new Scanner(System.in);
    int kg = sc.nextInt();
    int[] dp = new int[5001];
    Arrays.fill(dp, NO_VALUE);

    dp[3] = 1;
    dp[5] = 1;

    for (int i = 6; i <= kg; i++) {
      if (dp[i - 3] != NO_VALUE || dp[i - 5] != NO_VALUE) {
        dp[i] = Integer.min(dp[i - 3], dp[i - 5]) + 1;
      }
    }

    if (dp[kg] == NO_VALUE) {
      System.out.println(-1);
    } else {
      System.out.println(dp[kg]);
    }
  }
}
