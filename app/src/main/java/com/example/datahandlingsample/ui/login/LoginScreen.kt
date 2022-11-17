package com.example.datahandlingsample.ui.login

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.datahandlingsample.MainActivity
import com.example.datahandlingsample.data.entities.User
import com.example.datahandlingsample.ui.LoginViewModel


@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel(), context:Context) {
    var firstName by remember {
        mutableStateOf("")
    }

    var lastName by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        TextField(
            value = firstName,
            onValueChange = {firstName = it},
            label = { Text("Enter First Name")},
            modifier = Modifier.padding(16.dp)
        )

        TextField(
            value = lastName,
            onValueChange = {lastName = it},
            label = { Text("Enter Last Name")},
            modifier = Modifier.padding(16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if(firstName.isEmpty() && lastName.isEmpty()){
                Toast.makeText(context,"Error", Toast.LENGTH_LONG).show()

            }else{
               // val user = User(firstName, lastName)
                loginViewModel.insert(User(firstName,lastName))
                Toast.makeText(context,"Success",Toast.LENGTH_LONG).show()
            }
        }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Save button")
            Text(text = "Save")
        }

    }

}
