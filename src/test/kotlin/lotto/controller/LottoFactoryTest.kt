package lotto.controller

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumbers
import lotto.domain.numberGenerator.FixedLottoLottoNumberGenerator
import lotto.domain.numberGenerator.RandomLottoLottoNumberGenerator

class LottoFactoryTest : BehaviorSpec({

    Given("수동으로 로또를 발급 받을때") {
        val lottoFactory = LottoFactory(RandomLottoLottoNumberGenerator())
        val manualLottoCount = 2
        val inputMoney = 5000
        val manualLottoNumbers = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(7, 8, 9, 10, 11, 12)
        )

        When("입력 받은 번호로 수동 로또 번호를 생성할 때") {
            val manualLottos = manualLottoNumbers.map { inputNumbers ->
                val numberGenerator = FixedLottoLottoNumberGenerator(inputNumbers)
                LottoNumbers(numberGenerator.generateNumbers())
            }

            Then("예상되는 수동 로또 번호들이 반환되어야 한다") {
                manualLottos.size shouldBe manualLottoCount
                manualLottos[0].lottoNumbers.map { it.value } shouldBe manualLottoNumbers[0]
                manualLottos[1].lottoNumbers.map { it.value } shouldBe manualLottoNumbers[1]
            }
        }

        When("수동 로또 번호와 입력 금액으로 로또를 생성할 때") {
            val manualLottos = manualLottoNumbers.map { inputNumbers ->
                val numberGenerator = FixedLottoLottoNumberGenerator(inputNumbers)
                LottoNumbers(numberGenerator.generateNumbers())
            }

            val lottos = lottoFactory.createLottos(manualLottos, inputMoney)

            Then("예상되는 총 로또 개수는 수동 + 자동이다.") {
                lottos.getSize() shouldBe 5
            }
        }
    }
})