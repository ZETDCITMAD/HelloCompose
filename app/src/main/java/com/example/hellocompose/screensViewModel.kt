package com.example.hellocompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

const val LOGIN_SCREEN: Int = 1
const val HOME_PAGE: Int = 0
const val SCREEN_THREE: Int = 2
const val MAX_SCREENS: Int = 3

class screensViewModel: ViewModel() {

    var newScreenNumber by mutableIntStateOf(0)
    fun changeScreen(oldScreenNumber: Int){
        when(oldScreenNumber){
            HOME_PAGE -> newScreenNumber = LOGIN_SCREEN
            LOGIN_SCREEN -> newScreenNumber = SCREEN_THREE
            SCREEN_THREE -> newScreenNumber = HOME_PAGE
        }
    }
    fun goToHome(){
        newScreenNumber = HOME_PAGE
    }
    fun goToLogin(){
        newScreenNumber = LOGIN_SCREEN
    }
    /*fun nextScreen(currentScreen: Int) {
        if (currentScreen < MAX_SCREENS) {
            newScreenNumber = currentScreen.inc()
        }
        else{
            newScreenNumber = HOME_PAGE
        }
    }*/
}