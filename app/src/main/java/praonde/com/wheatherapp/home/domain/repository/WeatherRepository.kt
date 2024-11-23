package praonde.com.wheatherapp.home.domain.repository

import kotlinx.coroutines.flow.Flow
import praonde.com.wheatherapp.common.LoadingEvent
import praonde.com.wheatherapp.home.data.entity.PlaceEntity
import praonde.com.wheatherapp.home.domain.model.LocationDetails
import praonde.com.wheatherapp.home.domain.model.PlaceInfo

interface WeatherRepository {

    fun getSearchPlaces(searchText: String): Flow<LoadingEvent<List<PlaceInfo>>>

    fun getLocationDetails(locationID: Int): Flow<LoadingEvent<LocationDetails>>
}