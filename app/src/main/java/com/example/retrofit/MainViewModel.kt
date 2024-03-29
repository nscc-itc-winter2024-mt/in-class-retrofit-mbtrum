package com.example.retrofit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.models.Weather
import com.example.retrofit.retrofit.APIClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _weatherStateFlow = MutableStateFlow<Weather?>(null)

    val weatherStateFlow: StateFlow<Weather?> = _weatherStateFlow.asStateFlow()

    fun updateWeather(coordinates: String) {
        viewModelScope.launch {
            val weather = APIClient.APIService.getWeather(
                "57790511bb914ec88a3211429241101", // PUT YOUR KEY HERE
                coordinates,
                "3",
                "no",
                "no"
            )

            // Update ViewModel state
            _weatherStateFlow.value = weather
        }
    }

}