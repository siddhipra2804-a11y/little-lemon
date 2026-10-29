package com.example.myandroidapp

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myandroidapp.Onboarding

@Composable
fun MyNavigation(navController: NavHostController, context: Context) {
    // SharedPreferences से चेक करें कि डेटा सेव है या नहीं
    val sharedPreferences = context.getSharedPreferences("LittleLemon", Context.MODE_PRIVATE)
    val firstName = sharedPreferences.getString("firstName", "") ?: ""

    // अगर फर्स्ट नेम खाली है तो Onboarding, वरना Home से शुरू करें
    val startDestination = if (firstName.isBlank()) Onboarding.route else Home.route

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Onboarding.route) {
            Onboarding(navController = navController)
    }
        composable(Home.route) {
            HomeScreen()
        }
        composable(Profile.route) {
            ProfileScreen()
        }
    }
}

@Composable
fun Onboarding(navController: NavHostController) {
    TODO("Not yet implemented")
}