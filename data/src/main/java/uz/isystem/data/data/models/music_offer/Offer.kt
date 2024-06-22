package uz.isystem.data.data.models.music_offer

data class Offer(
    val id: Int,
    val price: Price,
    val title: String,
    val town: String
)