package com.neppplus.pizzaorderapp

import android.os.Bundle
import com.neppplus.pizzaorderapp.adapters.MainViewPagerAdapter
import androidx.viewpager.widget.ViewPager



class MainActivity : BaseActivity() {

    lateinit var mvpa : MainViewPagerAdapter
    lateinit var mainViewPager : ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    //버튼 클릭등의 이벤트 관련 코드 모음
    override fun setupEvents() {

    }

    // 화면의 데이터를 표시하기 위한 코드 모음
    override fun setValues() {
        // ViewPager 어댑터 설정
        mvpa = MainViewPagerAdapter(supportFragmentManager)

        // mainViewPager 초기화
        mainViewPager = findViewById(R.id.mainViewPager)

        // ViewPager에 Adapter 설정
        mainViewPager.adapter = mvpa

        // val mainTabLayout = findViewById<TabLayout>(R.id.mainTabLayout)
        // mainTabLayout.setupWithViewPager(mainViewPager)
    }

}