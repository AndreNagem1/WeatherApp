package praonde.com.wheatherapp.home.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import praonde.com.wheatherapp.common.LoadingEvent
import praonde.com.wheatherapp.common.mapSuccess
import praonde.com.wheatherapp.home.data.entity.PlaceEntity
import praonde.com.wheatherapp.home.data.remote.datastore.WeatherDataStore
import praonde.com.wheatherapp.home.domain.model.Condition
import praonde.com.wheatherapp.home.domain.model.LocationDetails
import praonde.com.wheatherapp.home.domain.model.PlaceInfo
import praonde.com.wheatherapp.home.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val dataStore: WeatherDataStore) :
    WeatherRepository {

    override fun getSearchPlaces(searchText: String): Flow<LoadingEvent<List<PlaceInfo>>> {
        return dataStore.getAvailableLocations(searchText = searchText).mapSuccess {

            val result = mutableListOf<PlaceInfo>()

            it.forEach { entity ->
                val placeInfo = PlaceInfo(
                    id = entity.id,
                    name = entity.region,
                    temperature = 2.3
                )

                result.add(placeInfo)
            }

            result
        }
    }

    override fun getLocationDetails(locationID: Int): Flow<LoadingEvent<LocationDetails>> {
        return dataStore.getLocationDetails(locationID = locationID).mapSuccess {
            LocationDetails(
                id = locationID,
                name = it.location.region,
                condition = Condition.entries
                    .firstOrNull { condition -> condition.code == it.current.condition.code }
                    ?: Condition.CONDITION_1,
                temp = it.current.tempC,
                humidity = it.current.humidity,
                uv = it.current.uv,
                tempFeelsLike = it.current.feelslikeC
            )
        }
    }
}