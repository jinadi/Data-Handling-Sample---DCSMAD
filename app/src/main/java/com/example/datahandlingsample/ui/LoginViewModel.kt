package com.example.datahandlingsample.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.datahandlingsample.data.entities.User
import com.example.datahandlingsample.data.repositories.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class LoginViewModel(
    private val repository: UserRepository
):ViewModel() {
    var usersState by mutableStateOf(mutableListOf<User>())
    private  set

    fun insert(user:User) = CoroutineScope(Dispatchers.Main).launch{
        repository.insert(user)
    }

    fun delete(user:User) = CoroutineScope(Dispatchers.Main).launch{
        repository.delete(user)
    }

    init {
        viewModelScope.launch {
          repository.getAllUsers().collect(){
                usersState = it as MutableList<User>
            }
        }
    }


}