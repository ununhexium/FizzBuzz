package fizzbuzz

object SimpleFizzBuzz : FizzBuzz {
  override fun fizzBuzz(range: IntRange): List<String> {
    val result = mutableListOf<String>()

    range.forEach {
      result.add(
          when {
            it % 3 == 0 && it % 5 == 0 -> "FizzBuzz"
            it % 5 == 0 -> "Buzz"
            it % 3 == 0 -> "Fizz"
            else -> it.toString()
          }
      )
    }

    return result
  }
}
