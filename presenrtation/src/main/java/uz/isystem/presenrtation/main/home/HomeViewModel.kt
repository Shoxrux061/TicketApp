package uz.isystem.presenrtation.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.isystem.core.ResultWrapper
import uz.isystem.data.data.models.MusicalOffersResponse
import uz.isystem.domain.TicketsRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: TicketsRepository<MusicalOffersResponse?>
) : ViewModel() {


    private val successData: MutableLiveData<MusicalOffersResponse?> =
        MutableLiveData<MusicalOffersResponse?>()
    val successResponse: LiveData<MusicalOffersResponse?>
        get() = successData

    private val errorData: MutableLiveData<String?> = MutableLiveData<String?>()
    val errorResponseEvery: LiveData<String?>
        get() = errorData

    fun getMusicalOffers() {
        viewModelScope.launch {
            when (val result = repository.getTickets(


            )) {
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