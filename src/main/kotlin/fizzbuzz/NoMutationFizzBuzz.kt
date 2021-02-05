package fizzbuzz

object NoMutationFizzBuzz: FizzBuzz {
  override fun fizzBuzz(range: IntRange): List<String> =
      range.map {
        when {
          it % 3 == 0 && it % 5 == 0 -> "FizzBuzz"
          it % 5 == 0 -> "Buzz"
          it % 3 == 0 -> "Fizz"
          else -> it.toString()
        }
      }
}