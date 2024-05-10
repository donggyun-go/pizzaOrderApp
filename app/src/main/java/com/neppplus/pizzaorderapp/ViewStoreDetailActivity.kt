package com.neppplus.pizzaorderapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.neppplus.pizzaorderapp.datas.Store

class ViewStoreDetailActivity : BaseActivity() {

    lateinit var mStoreData : Store
    lateinit var storeLogoImg: ImageView
    lateinit var storePhoneNumTxt: TextView
    lateinit var storeNameTxt : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_store_detail_activity)

        storeLogoImg = findViewById(R.id.storeLogoImg)
        storePhoneNumTxt = findViewById(R.id.storePhoneTxt)
        storeNameTxt = findViewById(R.id.storeNameTxt)
        setupEvents()
        setValues()

    }
    override fun setupEvents() {

    }

    override fun setValues() {

        mStoreData = intent.getSerializableExtra("storeData") as Store

        Glide.with(mContext).load(mStoreData.logoURL).into(storeLogoImg)

        storePhoneNumTxt.text = mStoreData.phone
        storeNameTxt.text = mStoreData.name

    }

}