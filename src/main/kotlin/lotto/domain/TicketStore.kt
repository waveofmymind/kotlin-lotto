package lotto.domain


private const val TICKET_PRICE = 1000

object TicketStore {

    fun buyTickets(money: Int): LottoTickets {
        require(money >= TICKET_PRICE) { "$money 는 티켓 가격보다 낮을 수 없어요." }
        require(money % TICKET_PRICE == 0) { "잔돈 ${money % TICKET_PRICE} 이 남을 수 없어요." }

        return LottoTickets.randomTickets(money / TICKET_PRICE)
    }

    fun profitability(lottoTickets: LottoTickets, winningTicket: LottoTicket): Double {
        val benefitPrice = lottoTickets.benefitPrice(winningTicket)
        return (benefitPrice.toDouble() / (TICKET_PRICE * lottoTickets.count()))
    }

}