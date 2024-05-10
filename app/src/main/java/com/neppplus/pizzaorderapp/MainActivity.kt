package com.neppplus.pizzaorderapp

import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.neppplus.pizzaorderapp.adapters.MainViewPagerAdapter

class MainActivity : BaseActivity() {

    private lateinit var mvpa: MainViewPagerAdapter
    private lateinit var mainViewPager: ViewPager
    private lateinit var mainTabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        // 이벤트 관련 코드는 여기에 추가하십시오.
    }

    override fun setValues() {
        // ViewPager와 TabLayout 초기화
        mainViewPager = findViewById(R.id.mainViewPager)
        mainTabLayout = findViewById(R.id.mainTabLayout)

        // ViewPager 어댑터 설정
        mvpa = MainViewPagerAdapter(supportFragmentManager)
        mainViewPager.adapter = mvpa

        // TabLayout과 ViewPager 연동
        mainTabLayout.setupWithViewPager(mainViewPager)
    }
}