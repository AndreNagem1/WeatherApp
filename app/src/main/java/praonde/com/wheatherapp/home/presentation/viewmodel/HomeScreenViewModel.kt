package praonde.com.wheatherapp.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import praonde.com.wheatherapp.common.LoadingEvent
import praonde.com.wheatherapp.home.data.entity.PlaceEntity
import praonde.com.wheatherapp.home.domain.WeatherRepository
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val repository: WeatherRepository) :
    ViewModel() {

    private val showWeatherDetails = MutableStateFlow(false)
    private val searchText = MutableStateFlow("")
    private val weatherDataLoadingEvent =
        MutableStateFlow<LoadingEvent<List<PlaceEntity>>>(LoadingEvent.Idle)

    val state = combine(
        searchText,
        weatherDataLoadingEvent,
        showWeatherDetails
    ) { searchText, weatherDataValue, showWeatherDetails ->

        HomeScreenState(
            searchText = searchText,
            weatherDataLoadingEvent = if (searchText.isEmpty()) LoadingEvent.Idle else weatherDataValue,
            showWeatherDetails = showWeatherDetails
        )

    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        HomeScreenState(
            searchText = "",
            weatherDataLoadingEvent = LoadingEvent.Idle,
            showWeatherDetails = false
        )
    )

    fun onSearchTextChange(newText: String) {
        searchText.value = newText
        showWeatherDetails.value = false

        viewModelScope.launch {
            repository.getSearchPlaces(searchText = newText)
                .collectLatest { response ->
                    weatherDataLoadingEvent.value = response
                }
        }
    }

    fun onSearchItemClick() {
        showWeatherDetails.value = true
    }
}