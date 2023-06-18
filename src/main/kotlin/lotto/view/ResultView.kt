package lotto.view

import lotto.controller.MatchResult
import lotto.domain.Lottos
import lotto.domain.Prize

class ResultView {

    fun printLottoInfo(lottos: Lottos) {
        println("${lottos.getSize()}개를 구매했습니다.")
        lottos.lottoList.forEach {
            println(it.lottoNumbers)
        }
        println()
    }

    fun printStatistics(matchResult: MatchResult, earningRate: Double) {
        println()
        println("당첨 통계")
        println("---------")

        for (prize in Prize.values()) {
            val numberOfMatchesForPrize = matchResult.getNumberOfMatchesForPrize(prize)
            println("${prize.matchCount}개 일치 (${prize.amount}원) - ${numberOfMatchesForPrize}개")
        }

        val isProfit = matchResult.isProfit(earningRate)
        val resultMessage = if (isProfit) "(이익)" else "(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
        println("총 수익률은 %.2f입니다. $resultMessage".format(earningRate))
    }
}
