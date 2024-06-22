package uz.isystem.data.data.repo

import kotlinx.coroutines.Dispatchers
import uz.isystem.core.ResultWrapper
import uz.isystem.core.parseResponse
import uz.isystem.data.data.models.ticket_offer.TicketOfferResponse
import uz.isystem.data.data.network.OffersService
import uz.isystem.domain.TicketOfferRepository
import javax.inject.Inject

class TicketOfferRepositoryImpl @Inject constructor(private val service:OffersService) : TicketOfferRepository<TicketOfferResponse?> {
    override suspend fun getTicketOffers(): ResultWrapper<TicketOfferResponse?, Any?> {
        return parseResponse(Dispatchers.IO){
            service.getTicketOffer()
        }
    }
}