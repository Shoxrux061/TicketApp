package uz.isystem.domain

import uz.isystem.core.ResultWrapper

interface TicketOfferRepository<T> {

    suspend fun getTicketOffers(): ResultWrapper<T?, Any?>

}