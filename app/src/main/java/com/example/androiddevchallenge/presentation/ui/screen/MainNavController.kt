package com.example.androiddevchallenge.presentation.ui.screen

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.presentation.ui.screen.details.DetailsScreen
import com.example.androiddevchallenge.presentation.ui.screen.list.ListScreen
import com.example.androiddevchallenge.presentation.viewmodel.MainViewModel

@Composable
fun MainNavController(viewModel: MainViewModel) {
    val navController = rememberNavController()
    val (title, setTitle) = remember { mutableStateOf("Puppy Adoption") }
    val (canPop, setCanPop) = remember { mutableStateOf(false) }
    val scaffoldState: ScaffoldState = rememberScaffoldState()

    navController.addOnDestinationChangedListener { controller, _, _ ->
        setCanPop(controller.previousBackStackEntry != null)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = title)
                },
                navigationIcon = if (canPop) {
                    {
                        IconButton(
                            onClick = {
                                navController.popBackStack()
                            }
                        ) {
                            Icon(Icons.Outlined.ArrowBack, "back")
                        }
                    }
                } else { null }
            )
        },
        scaffoldState = scaffoldState
    ) {
        NavHost(navController, startDestination = "list") {
            composable("list") {
                ListScreen(navController, viewModel.cats, setTitle)
            }
            composable("details/{id}") {
                DetailsScreen(viewModel.cats, id = it.arguments?.getString("id").orEmpty(), setTitle)
            }
        }
    }
}
