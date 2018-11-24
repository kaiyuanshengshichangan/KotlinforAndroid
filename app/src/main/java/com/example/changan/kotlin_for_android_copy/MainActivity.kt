package com.example.changan.kotlin_for_android_copy

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.changan.kotlin_for_android_copy.ui.activitys.WeatherListActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

/**
 * 天气首页列表
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textview.setText("可以啦哈哈哈");
        textview.setOnClickListener {
            startActivity<WeatherListActivity>()
        }
    }
}
