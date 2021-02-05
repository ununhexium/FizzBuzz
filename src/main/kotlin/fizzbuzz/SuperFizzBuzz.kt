package fizzbuzz

object SuperFizzBuzz : GenericFizzBuzz {

  override fun fizzBuzz(range: IntRange, mappings: Map<Int, String>): List<String> =
      range.map { number ->
        val result = mappings.map { (divisor, word) ->
          if (number % divisor == 0) word else null
        }.fold("") { acc, e ->
          acc + (e ?: "")
        }

        if (result.isEmpty()) number.toString() else result
      }
}
