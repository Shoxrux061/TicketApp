package uz.isystem.data.data.repo

import kotlinx.coroutines.Dispatchers
import uz.isystem.core.ResultWrapper
import uz.isystem.core.parseResponse
import uz.isystem.data.data.network.OffersService
import uz.isystem.domain.TicketsRepository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val service: OffersService) : TicketsRepository {
    override suspend fun getTickets(): ResultWrapper<Any?, Any?> {
        return parseResponse(Dispatchers.IO) {
            service.getMusicalOffer()
        }
    }
}