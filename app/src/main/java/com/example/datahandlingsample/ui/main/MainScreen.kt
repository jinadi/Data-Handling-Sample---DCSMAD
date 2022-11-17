package com.example.datahandlingsample.ui.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.datahandlingsample.ui.LoginViewModel

@Composable
fun MainScreen(loginViewModel: LoginViewModel){
    
    //val users = loginViewModel.userState

    LazyColumn(modifier = Modifier){
        itemsIndexed(loginViewModel.usersState){ index, item ->
            Text(
                text = "${index+1} ${item.firstName} ${item.lastName}",
                fontSize = 24.sp,
                textAlign = TextAlign.Left,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            )
        }
    }
}