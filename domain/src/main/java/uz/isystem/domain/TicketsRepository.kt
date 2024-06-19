package uz.isystem.domain

import uz.isystem.core.ResultWrapper

interface TicketsRepository {
    suspend fun getTickets(): ResultWrapper<Any?,Any?>

}
