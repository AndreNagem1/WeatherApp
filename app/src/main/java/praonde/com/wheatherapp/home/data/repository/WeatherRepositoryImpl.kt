package praonde.com.wheatherapp.home.data.repository

import kotlinx.coroutines.flow.Flow
import praonde.com.wheatherapp.common.LoadingEvent
import praonde.com.wheatherapp.home.data.entity.PlaceEntity
import praonde.com.wheatherapp.home.data.remote.datastore.WeatherDataStore
import praonde.com.wheatherapp.home.domain.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val dataStore: WeatherDataStore) :
    WeatherRepository {

    override fun getSearchPlaces(searchText: String): Flow<LoadingEvent<List<PlaceEntity>>> {
        return dataStore.getAvailableLocations(searchText = searchText)
    }
}