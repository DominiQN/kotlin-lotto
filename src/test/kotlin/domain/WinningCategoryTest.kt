package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class WinningCategoryTest {
    @Test
    fun `당첨항목은 '3개 일치', '4개 일치', '5개 일치', '6개 일치'가 있다`() {
        assertThat(WinningCategory.values().map { it.name })
            .containsExactly(
                "THREE_CORRECT",
                "FOUR_CORRECT",
                "FIVE_CORRECT",
                "SIX_CORRECT"
            )
    }

    @ParameterizedTest
    @CsvSource(
        "THREE_CORRECT, 3",
        "FOUR_CORRECT, 4",
        "FIVE_CORRECT, 5",
        "SIX_CORRECT, 6"
    )
    fun `각 당첨항목마다 일치하는 개수를 가지고 있다`(category: WinningCategory, numberOfMatched: Int) {
        assertThat(category.numberOfMatched).isEqualTo(numberOfMatched)
    }
}
