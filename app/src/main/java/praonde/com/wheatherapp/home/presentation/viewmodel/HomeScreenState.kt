package praonde.com.wheatherapp.home.presentation.viewmodel

import praonde.com.wheatherapp.common.LoadingEvent
import praonde.com.wheatherapp.home.domain.model.LocationDetails
import praonde.com.wheatherapp.home.domain.model.PlaceInfo

class HomeScreenState(
    val searchText: String,
    val listLocationsLoadingEvent: LoadingEvent<List<PlaceInfo>>,
    val locationDetailsLoadingEvent: LoadingEvent<LocationDetails>,
    val showWeatherDetails: Boolean
)