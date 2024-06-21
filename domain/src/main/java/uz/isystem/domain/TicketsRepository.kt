package uz.isystem.domain

import uz.isystem.core.ResultWrapper
import javax.inject.Singleton


interface TicketsRepository<T> {
    suspend fun getTickets(): ResultWrapper<T?,Any?>

}
