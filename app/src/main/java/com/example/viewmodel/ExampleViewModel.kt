package com.example.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class ExampleViewModel: ViewModel() {
    var background by mutableStateOf(Color.White)
        private set
    fun changeBackgroundColor(){
        background = Color.Red
    }
}