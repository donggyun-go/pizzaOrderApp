package com.neppplus.pizzaorderapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    //버튼 클릭등의 이벤트 관련 코드 모음
    override fun setupEvents() {

    }

    // 화면의 데이터를 표시하기 위한 코드 모음
    override fun setValues() {

    }

}