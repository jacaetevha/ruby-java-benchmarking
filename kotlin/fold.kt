fun <T, R> Collection<T>.fold(
    initial: R, 
    combine: (acc: R, nextElement: T) -> R
): R {
    var accumulator: R = initial
    for (element: T in this) {
        accumulator = combine(accumulator, element)
    }
    return accumulator
}

fun main(args: Array<String>) {
  val arraySize = Integer.parseInt(System.getProperty("ARRAY_SIZE", "10000"))
  val count = Integer.parseInt(System.getProperty("COUNT", "1000"))
  val items = IntArray(arraySize) { it }
  val formatter = "%.6f"

  println("COUNT: " + count)
  println("ARRAY SIZE: " + arraySize)
  println("\n\n        TOTAL")

  var start = System.currentTimeMillis()
  System.gc()
  repeat(count) {
    items.sum()
  }
  var finish = System.currentTimeMillis()
  var total = finish - start
  println("sum     " + formatter.format(total/1000.0));

  System.gc()
  repeat(count) {
    items.fold(0, { acc, i -> acc + i })
  }
  finish = System.currentTimeMillis()
  total = finish - start

  println("fold    " + formatter.format(total/1000.0));
}