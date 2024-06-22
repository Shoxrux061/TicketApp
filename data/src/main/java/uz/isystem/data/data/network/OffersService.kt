package uz.isystem.data.data.network

import retrofit2.Response
import retrofit2.http.GET
import uz.isystem.data.data.models.music_offer.MusicalOffersResponse
import uz.isystem.data.data.models.ticket_offer.TicketOfferResponse

interface OffersService {
    @GET("ad9a46ba-276c-4a81-88a6-c068e51cce3a")
    suspend fun getMusicalOffer():Response<MusicalOffersResponse?>

    @GET("v3/38b5205d-1a3d-4c2f-9d77-2f9d1ef01a4a")
    suspend fun getTicketOffer():Response<TicketOfferResponse?>
}