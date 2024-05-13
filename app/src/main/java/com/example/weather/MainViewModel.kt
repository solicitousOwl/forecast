package com.example.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather.adapters.WeatherModel

class MainViewModel : ViewModel() {
    // обновляет и хранит карточку выбранного дня
    val liveDataCurrent = MutableLiveData<WeatherModel>()
    // обновляет и хранит карточку списка
    val liveDataList = MutableLiveData<List<WeatherModel >>()

}