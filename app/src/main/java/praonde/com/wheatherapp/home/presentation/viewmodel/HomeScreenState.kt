package praonde.com.wheatherapp.home.presentation.viewmodel

import praonde.com.wheatherapp.common.SubmitLoadingState

class HomeScreenState(
    val searchText: String,
    val weatherData: SubmitLoadingState<String>,
)