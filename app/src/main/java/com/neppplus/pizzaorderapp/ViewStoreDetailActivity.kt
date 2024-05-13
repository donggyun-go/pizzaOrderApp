package com.neppplus.pizzaorderapp

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import com.neppplus.pizzaorderapp.datas.Store

class ViewStoreDetailActivity : BaseActivity() {

    lateinit var mStoreData : Store
    lateinit var storeLogoImg: ImageView
    lateinit var storePhoneNumTxt: TextView
    lateinit var storeNameTxt : TextView
    lateinit var callPhoneBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_store_detail_activity)

        storeLogoImg = findViewById(R.id.storeLogoImg)
        storePhoneNumTxt = findViewById(R.id.storePhoneTxt)
        storeNameTxt = findViewById(R.id.storeNameTxt)
        callPhoneBtn = findViewById(R.id.callPhoneBtn)
        setupEvents()
        setValues()

    }

    override fun setupEvents() {

        callPhoneBtn.setOnClickListener{

            val permissionListener = object : PermissionListener {
                override fun onPermissionGranted(){

                    val myUri = Uri.parse("tel:${mStoreData.phone}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }
                
                override fun onPermissionDenied(deniedPermission: MutableList<String>?){
                    Toast.makeText(mContext, "전화연결 권한이 없습니다",Toast.LENGTH_SHORT).show()
                }
            }

            TedPermission.create()
                .setPermissionListener(permissionListener)
                .setDeniedMessage("[설정] 에서 전화 권한을 켜주세요.")
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()

        }
    }

    override fun setValues() {

        mStoreData = intent.getSerializableExtra("storeData") as Store

        Glide.with(mContext).load(mStoreData.logoURL).into(storeLogoImg)

        storePhoneNumTxt.text = mStoreData.phone
        storeNameTxt.text = mStoreData.name

    }

}