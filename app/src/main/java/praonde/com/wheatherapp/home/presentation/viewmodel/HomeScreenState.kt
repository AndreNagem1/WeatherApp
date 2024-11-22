package praonde.com.wheatherapp.home.presentation.viewmodel

import praonde.com.wheatherapp.common.LoadingEvent
import praonde.com.wheatherapp.home.data.entity.PlaceEntity

class HomeScreenState(
    val searchText: String,
    val weatherDataLoadingEvent: LoadingEvent<List<PlaceEntity>>,
    val showWeatherDetails: Boolean
)