package praonde.com.wheatherapp.home.data.remote.datastore

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import praonde.com.wheatherapp.common.LoadingEvent
import praonde.com.wheatherapp.home.data.entity.LocationDetailsEntity
import praonde.com.wheatherapp.home.data.entity.PlaceEntity
import praonde.com.wheatherapp.home.data.remote.service.WeatherService
import javax.inject.Inject

class WeatherDataStore @Inject constructor(private val weatherService: WeatherService) {

    fun getAvailableLocations(searchText: String): Flow<LoadingEvent<List<PlaceEntity>>> {
        return flow {
            emit(LoadingEvent.Loading)
            val response = weatherService.getAvailableLocations(
                searchText = searchText
            )
            if (response.isSuccessful) {
                response.body()?.let { emit(LoadingEvent.Success(it)) }
            } else {
                try {
                    throw Exception("Error fetching places: ${response.code()} ${response.message()}")
                } catch (e: Exception) {
                    throw Exception("Error fetching places:")
                }
            }
        }.flowOn(Dispatchers.IO)
    }

    fun getLocationDetails(locationID: Int): Flow<LoadingEvent<LocationDetailsEntity>> {
        return flow {
            emit(LoadingEvent.Loading)
            val response = weatherService.getLocationDetails(
                locationID = "id:$locationID"
            )
            if (response.isSuccessful) {
                response.body()?.let { emit(LoadingEvent.Success(it)) }
            } else {
                try {
                    throw Exception("Error location details: ${response.code()} ${response.message()}")
                } catch (e: Exception) {
                    throw Exception("Error locations details")
                }
            }

        }.flowOn(Dispatchers.IO)

    }
}