package praonde.com.wheatherapp.home.domain

import kotlinx.coroutines.flow.Flow
import praonde.com.wheatherapp.common.LoadingEvent
import praonde.com.wheatherapp.home.data.entity.PlaceEntity

interface WeatherRepository {

    fun getSearchPlaces(searchText: String): Flow<LoadingEvent<List<PlaceEntity>>>
}