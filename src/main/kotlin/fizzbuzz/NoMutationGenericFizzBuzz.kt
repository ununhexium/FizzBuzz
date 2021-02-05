package fizzbuzz

object NoMutationGenericFizzBuzz : GenericFizzBuzz {
  override fun fizzBuzz(range: IntRange, mappings: Map<Int, String>) =
      range.map { number ->
        with(
            mappings.entries
                .filter { (divisor, _) -> number % divisor == 0 }
                .joinToString(separator = "") { it.value }
        ) {
          if(isEmpty()) number.toString() else this
        }
      }
}
