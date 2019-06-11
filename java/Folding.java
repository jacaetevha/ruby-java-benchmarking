import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Folding {
  public static void main(String[] args) {
    DecimalFormat formatter = new DecimalFormat("#.######");
    int n = Integer.parseInt(System.getProperty("COUNT", "1000"));
    int arraySize = Integer.parseInt(System.getProperty("ARRAY_SIZE", "10000"));
    List<Integer> nums = new ArrayList<>(arraySize);
    for (int i = 1; i <= arraySize; i++) {
      nums.add(i);
    }

    System.out.println("COUNT: " + n);
    System.out.println("ARRAY SIZE: " + arraySize);
    System.out.println("\n\n           TOTAL");

    System.gc();
    long total = 0;
    for (int i = 0; i < n; i++) {
      total = total + time(nums, Folding::forLoop);
    }
    System.out.println("forLoop    " + formatter.format(total / 1000.0));

    System.gc();
    total = 0;
    for (int i = 0; i < n; i++) {
      total = total + time(nums, Folding::folding);
    }
    System.out.println("folding    " + formatter.format(total / 1000.0));
  }

  private static long time(List<Integer> nums, Function<List<Integer>, Long> f) {
    long start = System.currentTimeMillis();
    long result = f.apply(nums);
    long finish = System.currentTimeMillis();
    return finish - start;
  }

  private static Long forLoop(List<Integer> numbers) {
    long result = 0;
    for (int i = 0, l = numbers.size(); i < l; i++) {
      result += numbers.get(i);
    }
    return result;
  }

  private static Long folding(List<Integer> numbers) {
    return numbers.stream().mapToLong(Integer::intValue).sum();
  }
}
