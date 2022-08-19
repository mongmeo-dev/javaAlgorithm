public class P4673 {

  public static void main(String[] args) {
    int[] functionDResult = new int[10001];
    int num = 0;
    int result;
    String numToStr;

    while (num < 10000) {
      numToStr = String.valueOf(++num);
      result = num;
      for (char ch : numToStr.toCharArray()) {
        result += Integer.parseInt(Character.toString(ch));
      }
      if (result > 10000) {
        continue;
      }
      functionDResult[result]++;
    }

    for (int i = 1; i < 10001; i++) {
      if (functionDResult[i] == 0) {
        System.out.println(i);
      }
    }
  }

}
