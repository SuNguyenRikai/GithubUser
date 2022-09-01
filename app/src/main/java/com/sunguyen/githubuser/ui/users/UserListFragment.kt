package com.sunguyen.githubuser.ui.users

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.ViewModelProvider
import com.sunguyen.githubuser.ui.component.UserList
import com.sunguyen.githubuser.ui.main.MainViewModel
import com.sunguyen.githubuser.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserListFragment : Fragment() {
    private lateinit var viewModel: MainViewModel
    companion object {
        fun newInstance() = UserListFragment()
    }

    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            viewModel = ViewModelProvider(this@UserListFragment)[MainViewModel::class.java]
            setContent {

                AppTheme(
                ) {

                    val users = viewModel.users

                    val loading = viewModel.loading.value


                    val scaffoldState = rememberScaffoldState()

                    Scaffold(
                        scaffoldState = scaffoldState,
                    ) {
                        UserList(
                            loading = loading,
                            users = users
                        )
                    }
                }
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}