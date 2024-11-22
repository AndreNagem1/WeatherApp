package praonde.com.wheatherapp.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import praonde.com.wheatherapp.common.SubmitLoadingState
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor() : ViewModel() {

    private val showWeatherDetails = MutableStateFlow(false)
    private val searchText = MutableStateFlow("")
    private val weatherData =
        MutableStateFlow<SubmitLoadingState<String>>(SubmitLoadingState.Idle)

    val state = combine(
        searchText,
        weatherData,
        showWeatherDetails
    ) { searchText, weatherDataValue, showWeatherDetails ->

        if (searchText.isNotBlank()) {
            weatherData.value = SubmitLoadingState.Success("")
        }

        HomeScreenState(
            searchText = searchText,
            weatherDataSubmittable = if (searchText.isEmpty()) SubmitLoadingState.Idle else weatherDataValue,
            showWeatherDetails = showWeatherDetails
        )

    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        HomeScreenState(
            searchText = "",
            weatherDataSubmittable = SubmitLoadingState.Idle,
            showWeatherDetails = false
        )
    )

    fun onSearchTextChange(newText: String) {
        searchText.value = newText
        showWeatherDetails.value = false
    }

    fun onSearchItemClick() {
        showWeatherDetails.value = true
    }
}