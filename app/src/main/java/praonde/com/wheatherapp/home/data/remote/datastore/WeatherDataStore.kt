package praonde.com.wheatherapp.home.data.remote.datastore

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import praonde.com.wheatherapp.common.LoadingEvent
import praonde.com.wheatherapp.home.data.entity.PlaceEntity
import praonde.com.wheatherapp.home.data.remote.service.WeatherService
import javax.inject.Inject

class WeatherDataStore @Inject constructor(private val weatherService: WeatherService) {

    fun getAvailableLocations(searchText: String): Flow<LoadingEvent<List<PlaceEntity>>> {
        return flow {
            emit(LoadingEvent.Loading)
            val response = weatherService.getAvailableLocations(
                apiKey = "fa0f9c023c094469b66130756242111",
                searchText = searchText
            )
            if (response.isSuccessful) {
                response.body()?.let { emit(LoadingEvent.Success(it)) }
            } else {
                throw Exception("Error fetching places: ${response.code()} ${response.message()}")
            }
        }.flowOn(Dispatchers.IO)
    }
}