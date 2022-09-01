package com.sunguyen.githubuser.ui.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sunguyen.githubuser.data.model.User
import com.sunguyen.githubuser.data.repository.UserRepository
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

const val STATE_USER_LIST = "view.model.user.list"
@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val users: SnapshotStateList<User> = mutableStateListOf()
    val loading = mutableStateOf(false)
    init {

        var userList = savedStateHandle.get<List<User>>(STATE_USER_LIST)
        if (userList == null){
            loadUsers()
        } else {
            users.addAll(userList)
        }
    }

    private fun loadUsers(){
        viewModelScope.launch {
            loading.value = true
            val list = userRepository.getUsers(perPage = 100)
            savedStateHandle[STATE_USER_LIST] = list
            users.addAll(list)
            loading.value = false
        }
    }
}