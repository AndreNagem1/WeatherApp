package praonde.com.wheatherapp.home.data.remote.service

import praonde.com.wheatherapp.home.data.entity.PlaceEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("search.json")
    suspend fun getAvailableLocations(
        @Query("key") apiKey: String,
        @Query("q") searchText: String,
    ): Response<List<PlaceEntity>>
}