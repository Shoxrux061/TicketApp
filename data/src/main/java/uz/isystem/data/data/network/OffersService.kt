package uz.isystem.data.data.network

import retrofit2.Response
import retrofit2.http.GET
import uz.isystem.data.data.models.MusicalOffersResponse

interface OffersService {
    @GET("/v3/214a1713-bac0-4853-907c-a1dfc3cd05fd")
    suspend fun getMusicalOffer():Response<MusicalOffersResponse?>
}