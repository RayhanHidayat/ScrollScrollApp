package com.example.scrollscrollapp.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.scrollscrollapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sectionsPagerAdapter: SectionsPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        binding.vpHome.adapter = sectionsPagerAdapter
        binding.tabHome.setupWithViewPager(binding.vpHome)

        supportActionBar?.elevation = 0f
    }

}