package com.dev.carl.simplelistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dev.carl.simplelistapp.ui.theme.SimpleListAppTheme
import com.dev.carl.simplelistapp.ui.user.UserDetailScreen
import com.dev.carl.simplelistapp.ui.user.UserListScreen
import com.dev.carl.simplelistapp.ui.user.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleListAppTheme {
                val navController = rememberNavController()
                val viewModel: UserViewModel by viewModels()
                NavHost(
                    navController = navController,
                    startDestination = "userListScreen"
                ) {
                    composable(
                        "userListScreen"
                    ) {
                        UserListScreen(
                            navController = navController,
                            viewModel = viewModel
                        )
                    }
                    composable(
                        "userDetailScreen/{userId}",
                        arguments = listOf(navArgument("userId") { type = NavType.IntType }),
                    ) { navBackStackEntry ->
                        val userId = navBackStackEntry.arguments?.getInt("userId")
                        UserDetailScreen(
                            userId = userId ?: -1,
                            navController = navController,
                            viewModel = viewModel)
                    }
                }
            }
        }
    }
}
