package praonde.com.wheatherapp.home.data.remote.service

import praonde.com.wheatherapp.home.data.entity.LocationDetailsEntity
import praonde.com.wheatherapp.home.data.entity.PlaceEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("search.json")
    suspend fun getAvailableLocations(
        @Query("key") apiKey: String = "fa0f9c023c094469b66130756242111",
        @Query("q") searchText: String,
    ): Response<List<PlaceEntity>>

    @GET("current.json")
    suspend fun getLocationDetails(
        @Query("key") apiKey: String = "fa0f9c023c094469b66130756242111",
        @Query("q") locationID: String,
    ): Response<LocationDetailsEntity>
}