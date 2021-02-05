package fizzbuzz

object GenericFunctionalFizzBuzz : GenericFizzBuzz {

  override fun fizzBuzz(range: IntRange, mappings: Map<Int, String>): List<String> =
      range.map { number ->
        fun tester(divisor: Int, word: String): (String) -> String {
          return { previous ->
            previous + if (number % divisor == 0) word else ""
          }
        }

        val testers = mappings.map { (divisor, word) ->
          tester(divisor, word)
        }
        val terminator = { previous: String ->
          if (previous.isEmpty()) number.toString() else previous
        }

        val folded = (testers + terminator).reversed().foldRight("") { acc, e ->
          acc(e)
        }

        folded
      }
}
