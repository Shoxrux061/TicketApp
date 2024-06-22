package uz.isystem.domain

import uz.isystem.core.ResultWrapper


interface TicketsRepository<T> {
    suspend fun getMusicOffers(): ResultWrapper<T?,Any?>

}
