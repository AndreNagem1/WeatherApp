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
import praonde.com.wheatherapp.home.domain.model.LocationDetails
import praonde.com.wheatherapp.home.domain.model.PlaceInfo
import praonde.com.wheatherapp.home.domain.repository.WeatherRepository
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val repository: WeatherRepository) :
    ViewModel() {

    private val showWeatherDetails = MutableStateFlow(false)
    private val searchText = MutableStateFlow("")
    private val listLocationsLoadingEvent =
        MutableStateFlow<LoadingEvent<List<PlaceInfo>>>(LoadingEvent.Idle)
    private val locationsDetailsLoadingEvent =
        MutableStateFlow<LoadingEvent<LocationDetails>>(LoadingEvent.Idle)

    val state = combine(
        searchText,
        listLocationsLoadingEvent,
        showWeatherDetails,
        locationsDetailsLoadingEvent
    ) { searchText, weatherDataValue, showWeatherDetails, locationsDetailsLoadingEvent ->

        HomeScreenState(
            searchText = searchText,
            listLocationsLoadingEvent = if (searchText.isEmpty()) LoadingEvent.Idle else weatherDataValue,
            showWeatherDetails = showWeatherDetails,
            locationDetailsLoadingEvent = locationsDetailsLoadingEvent
        )

    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        HomeScreenState(
            searchText = searchText.value,
            listLocationsLoadingEvent = LoadingEvent.Idle,
            showWeatherDetails = false,
            locationDetailsLoadingEvent = LoadingEvent.Idle,
        )
    )

    fun onSearchTextChange(newText: String) {
        searchText.value = newText
        showWeatherDetails.value = false

        viewModelScope.launch {
            repository.getSearchPlaces(searchText = newText)
                .collectLatest { response ->
                    listLocationsLoadingEvent.value = response
                }
        }
    }

    fun getLocationDetails(locationID: Int) {
        showWeatherDetails.value = true

        viewModelScope.launch {
            repository.getLocationDetails(locationID = locationID)
                .collectLatest { response ->
                    locationsDetailsLoadingEvent.value = response
                }
        }
    }

}