package fizzbuzz

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class FizzBuzzTest {
  data class TestCase(val name: String, val function: (IntRange) -> List<String>)

  @TestFactory
  fun `classic fizzbuzz`(): Iterable<DynamicTest> {
    val fizzBuzz = listOf(
        TestCase("Simple", SimpleFizzBuzz::fizzBuzz),
        TestCase("Pure", NoMutationFizzBuzz::fizzBuzz),
        TestCase("Generic", NoMutationGenericFizzBuzz::fizzBuzz),
        TestCase("Functional", FunctionalFizzBuzz::fizzBuzz),
        TestCase("GenericFunctional", GenericFunctionalFizzBuzz::fizzBuzz),
        TestCase("Super", SuperFizzBuzz::fizzBuzz),
    )

    return fizzBuzz.map {
      DynamicTest.dynamicTest(it.name) {
        // given
        val inputRange = (0..15)

        // when
        val result = it.function(inputRange)

        // then
        val expected = listOf(
            "FizzBuzz",
            "1",
            "2",
            "Fizz",
            "4",
            "Buzz",
            "Fizz",
            "7",
            "8",
            "Fizz",
            "Buzz",
            "11",
            "Fizz",
            "13",
            "14",
            "FizzBuzz",
        )
        Assertions.assertThat(result).isEqualTo(expected)
      }
    }
  }
}