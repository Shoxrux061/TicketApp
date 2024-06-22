package uz.isystem.presenrtation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.isystem.core.ResultWrapper
import uz.isystem.data.data.models.ticket_offer.TicketOfferResponse
import uz.isystem.domain.TicketOfferRepository
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: TicketOfferRepository<TicketOfferResponse?>
) : ViewModel() {


    private val successData: MutableLiveData<TicketOfferResponse?> =
        MutableLiveData<TicketOfferResponse?>()
    val successResponse: LiveData<TicketOfferResponse?>
        get() = successData

    private val errorData: MutableLiveData<String?> = MutableLiveData<String?>()
    val errorResponseEvery: LiveData<String?>
        get() = errorData


    fun getTicketOffer() {

        viewModelScope.launch {
            when (val result = repository.getTicketOffers()) {
                is ResultWrapper.Success -> {
                    successData.postValue(result.data)
                }

                is ResultWrapper.Error -> {
                    errorData.postValue(result.message.toString())
                }

                is ResultWrapper.NetworkError -> {
                    errorData.postValue("No internet")
                }
            }
        }
    }
}