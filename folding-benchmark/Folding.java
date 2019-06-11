import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.util.function.*;

public class Folding {
  public static void main(String[] args) {
    DecimalFormat formatter = new DecimalFormat("#.######");
    int n = Integer.parseInt(System.getProperty("COUNT", "1000"));
    int arraySize = Integer.parseInt(System.getProperty("ARRAY_SIZE", "10000"));
    List<Integer> nums = new ArrayList<>(arraySize);
    for(int i = 1; i <= arraySize; i++) {
      nums.add(i);
    }

    System.out.println("COUNT: " + n);
    System.out.println("ARRAY SIZE: " + arraySize);
    System.out.println("\n\n           TOTAL");

    System.gc();
    long total = 0;
    for (int i=0; i<n; i++) {
      total = total + time(nums, Folding::forLoop);
    }
    System.out.println("forLoop    " + formatter.format(total/1000.0));

    System.gc();
    total = 0;
    for (int i=0; i<n; i++) {
      total = total + time(nums, Folding::folding);
    }
    System.out.println("folding    " + formatter.format(total/1000.0));
  }

  private static long time(List<Integer> nums, Function<List<Integer>, String> f) {
    long start = System.currentTimeMillis();
    String result = f.apply(nums);
    long finish = System.currentTimeMillis();
    return finish - start;
  }

  private static String forLoop(List<Integer> numbers) {
    StringBuilder s = new StringBuilder("Elements: ");
    for(int i=0, l=numbers.size(); i < l; i++) {
      s.append(numbers.get(i));
      if (i + 1 < l) {
        s.append(" ");
      }
    }
    return s.toString();
  }

  private static String folding(List<Integer> numbers) {
    String s = "Elements: ";
    String result = numbers
      .stream()
      .map(Object::toString)
      .collect(Collectors.joining(" "));
    return s + result;
  }
}
