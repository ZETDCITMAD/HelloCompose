package com.example.hellocompose.ui

import LoginView
import ScreenTwo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hellocompose.moreNavRoutes
import com.example.hellocompose.screensViewModel
enum class moreNavRoutes(){
    Login,
    Home,
    Screen_Three
}


@Composable
fun Greeting(modifier: Modifier = Modifier, screenNumber: Int = 0,
             navController : NavHostController = rememberNavController()) {
    val screensViewModel = viewModel<screensViewModel>()
    var screenSelector = screensViewModel.newScreenNumber /*{ mutableIntStateOf(screenNumber) }*/

    NavHost(
        navController = navController,
        startDestination = moreNavRoutes.Home.name,
        modifier = Modifier
    ){
        composable(route = moreNavRoutes.Home.name){
            ScreenTwo(onScreenSelect = { navController.navigate(moreNavRoutes.Login.name) })
        }
        composable(route = moreNavRoutes.Login.name){
            LoginView(onScreenSelect = { navController.navigate(moreNavRoutes.Screen_Three.name) })
        }
        composable(route = moreNavRoutes.Screen_Three.name){
            LoginView(onScreenSelect = { navController.navigate(moreNavRoutes.Home.name) })
        }

    }

// This is how we used to do things before @Vimbai taught us about Nav controllers

//    when (screenSelector){
//        1 ->
//            LoginView(onScreenSelect = { screensViewModel.changeScreen(screenSelector) })
//        0 ->
//            ScreenTwo(onScreenSelect = { screensViewModel.changeScreen(screenSelector) })
//        2 ->
//            ScreenThree( onScreenSelect = { screensViewModel.goToLogin() },
//                onHomeButtonClick=({ screensViewModel.goToHome() }))
//    }
}