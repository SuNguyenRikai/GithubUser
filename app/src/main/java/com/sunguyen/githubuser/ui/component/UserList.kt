package com.sunguyen.githubuser.ui.component

import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sunguyen.githubuser.data.model.User
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalMaterialApi
@ExperimentalCoroutinesApi
@Composable
fun UserList(
    loading: Boolean,
    users: List<User>
){
    Box(modifier = Modifier
        .background(color = MaterialTheme.colors.surface)
    ) {
        if (loading && users.isEmpty()) {
            UserListLoading()
        } else {
            LazyColumn {
                itemsIndexed(
                    items = users
                ) { index, user ->
                    UserCard(
                        user = user,
                        onClick = {

                        }
                    )
                }
            }
        }
    }
}