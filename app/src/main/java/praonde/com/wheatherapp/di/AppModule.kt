package praonde.com.wheatherapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import praonde.com.wheatherapp.home.data.remote.datastore.WeatherDataStore
import praonde.com.wheatherapp.home.data.remote.service.WeatherService
import praonde.com.wheatherapp.home.data.repository.WeatherRepositoryImpl
import praonde.com.wheatherapp.home.domain.WeatherRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.weatherapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideWeatherApiService(retrofit: Retrofit): WeatherService {
        return retrofit.create(WeatherService::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(
        dataStore: WeatherDataStore
    ): WeatherRepository = WeatherRepositoryImpl(dataStore)

    @Provides
    @Singleton
    fun provideWeatherDataStore(
        service: WeatherService
    ): WeatherDataStore = WeatherDataStore(service)
}