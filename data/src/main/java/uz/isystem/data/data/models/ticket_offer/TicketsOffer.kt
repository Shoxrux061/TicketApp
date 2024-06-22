package uz.isystem.data.data.models.ticket_offer

data class TicketsOffer(
    val id: Int,
    val price: Price,
    val time_range: List<String>,
    val title: String
)