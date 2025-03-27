package com.example.week2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.week2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // view binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBinding()
        initNavigation()
    }

    /**
     * view binding 초기화
     */
    private fun initBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    /**
     * bottomNavigationView 이벤트 처리
     * setupWithNavController bottomNavigationView와 navController를 인자로 받고
     * 바텀네비게이션에서 이동이 발생하면
     * 그에 맞춰서 navController가 fragment를 매핑
     * 이 과정에서
     */
    private fun initNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navHostFragment.findNavController())
        }
}
