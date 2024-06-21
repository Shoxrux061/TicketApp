package uz.isystem.data.data.repo

import kotlinx.coroutines.Dispatchers
import uz.isystem.core.ResultWrapper
import uz.isystem.core.parseResponse
import uz.isystem.data.data.models.MusicalOffersResponse
import uz.isystem.data.data.network.OffersService
import uz.isystem.domain.TicketsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton

class RepositoryImpl @Inject constructor(private val service: OffersService) : TicketsRepository<MusicalOffersResponse?> {
    override suspend fun getTickets(): ResultWrapper<MusicalOffersResponse?, Any?> {
        return parseResponse(Dispatchers.IO) {
            service.getMusicalOffer()
        }
    }
}