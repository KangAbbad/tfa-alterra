import java.util.*;

public class Playground {
  public static void main(String[] args) {
//    System.out.println(sumOfDigit(12345));
//    System.out.println(factorial(5));
//    System.out.println(fibonacciRecursive(9));

//    String[] names = {"a", "bc", "ad"};
//    sortStringExchange(names);
//    for (int k = 0; k < names.length; k++) {
//      System.out.println(names[k]);
//    }

//    int[] ratings = new int[]{-1, 3, 4, -2, 5, -7};
//    System.out.println(maxSubArray(ratings));

    List<Integer> ratings = Arrays.asList(-1, 3, 4, -2, 5, -7);
    System.out.println(maxSubArraySum(ratings));
  }

  static int sumOfDigit(int n) {
    if (n < 10) return n;
    int lastDigit = n % 10;
    int smallerSubProblem = n / 10;
    return lastDigit + sumOfDigit(smallerSubProblem);
  }

  static int factorial(int n) {
    if (n == 1) {
      return 1;
    } else {
      return n * factorial(n - 1);
    }
  }

  static Map<Long, Long> fibonacciMap = new HashMap<>();

  static long fibonacciRecursive(long n) {
    if (n <= 1) return n;
    if (fibonacciMap.containsKey(n)) return n;
    return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
  }

  static void sortStringExchange( String x []) {
    int i, j;
    String temp;

    for (i = 0;  i < x.length - 1;  i++) {
      for (j = i + 1; j < x.length; j++) {
        if (x[i].compareToIgnoreCase(x[j]) > 0) {
          temp = x [i];
          x[i] = x [j];
          x[j] = temp;
        }
      }
    }
  }

  static int maxSubArray(int[] nums) {
    int n = nums.length;
    int maximumSubArraySum = Integer.MIN_VALUE;
    int start = 0;
    int end = 0;

    for (int left = 0; left < n; left++) {
      int runningWindowSum = 0;
      for (int right = left; right < n; right++) {
        runningWindowSum += nums[right];

        if (runningWindowSum > maximumSubArraySum) {
          maximumSubArraySum = runningWindowSum;
          start = left;
          end = right;
        }
      }
    }
    System.out.println("Found Maximum Subarray between {} and {}" + start + end);
    return maximumSubArraySum;
  }

  static long maximumSum(List<Integer> arr) {
    long maxSum = 0;

    for (int i = 0; i < arr.size(); i++) {
      int currSum = 0;
      for (int j = i; j < arr.size(); j++) {
        currSum += arr.get(j);
        if (currSum > maxSum) {
          maxSum = currSum;
        }
      }
    }

    return maxSum;
  }

  static long maxSubArraySum(List<Integer> arr) {
    long maxSum = 0;
    long currSum = 0;

    for (int i = 0; i < arr.size(); i++) {
      if (arr.get(i) > currSum + arr.get(i)) {
        currSum = arr.get(i);
      } else {
        currSum += arr.get(i);
      }

      if (maxSum < currSum) {
        maxSum = currSum;
      }
    }

    return maxSum;
  }
}
