package fizzbuzz

object FunctionalFizzBuzz : FizzBuzz {

  override fun fizzBuzz(range: IntRange): List<String> =
      range.map { number ->
        fun tester(divisor: Int, word: String): (String) -> String {
          return { previous ->
            previous + if (number % divisor == 0) word else ""
          }
        }

        val fizzer = tester(3, "Fizz")
        val buzzer = tester(5, "Buzz")
        val terminator = { previous:String ->
          if(previous.isEmpty()) number.toString() else previous
        }

        terminator(buzzer(fizzer("")))
      }
}