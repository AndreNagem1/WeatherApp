package praonde.com.wheatherapp.home.domain.model

data class LocationDetails(
    val id: Int,
    val name: String,
    val condition: Condition,
    val temp: Double,
    val humidity: Int,
    val uv: Double,
    val tempFeelsLike: Double
)
