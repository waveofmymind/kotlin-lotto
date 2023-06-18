package lotto.controller

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumbers
import lotto.domain.Lottos
import lotto.domain.numberGenerator.FixedNumberGenerator

class MatchResultTest : BehaviorSpec({
    Given("로또 번호와 당첨 번호가 주어지면") {
        val money = 3000
        val lottos = Lottos.of(money)
        val winningNumbers = WinningNumbers(LottoNumbers(FixedNumberGenerator(listOf(1, 2, 3, 4, 5, 6))))

        When("MatchResult 를 생성할 때") {
            val matchResult = winningNumbers.calculateMatchResult(lottos)

            Then("총 수익률 계산이 정확해야 한다") {
                val expectedEarningRate = matchResult.calculateEarningRate(money)
                matchResult.calculateEarningRate(money) shouldBe expectedEarningRate
            }
        }
    }
})
