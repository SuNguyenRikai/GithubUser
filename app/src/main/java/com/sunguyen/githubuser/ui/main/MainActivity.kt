package com.sunguyen.githubuser.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sunguyen.githubuser.R
import com.sunguyen.githubuser.ui.users.UserListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, UserListFragment.newInstance())
                .commitNow()
        }
    }
}