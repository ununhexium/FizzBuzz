package fizzbuzz

interface GenericFizzBuzz : FizzBuzz {
  fun fizzBuzz(range: IntRange, mappings: Map<Int, String>): List<String>

  override fun fizzBuzz(range: IntRange): List<String> =
      fizzBuzz(range, mapOf(3 to "Fizz", 5 to "Buzz"))
}