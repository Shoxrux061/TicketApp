package uz.isystem.data.data.network

import retrofit2.Response
import retrofit2.http.GET
import uz.isystem.data.data.models.MusicalOffersResponse

interface OffersService {
    @GET("ad9a46ba-276c-4a81-88a6-c068e51cce3a")
    suspend fun getMusicalOffer():Response<MusicalOffersResponse?>
}