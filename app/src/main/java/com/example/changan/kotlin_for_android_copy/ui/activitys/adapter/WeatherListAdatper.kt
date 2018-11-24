package com.example.changan.kotlin_for_android_copy.ui.activitys.adapter

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.ViewGroup
import android.widget.TextView

/**
 * 天气列表item
 */
class WeatherListAdatper(val items: List<String>) : Adapter<WeatherListAdatper.ViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.textView.text = items[p1]
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(TextView(p0.context))
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView) {

    }
}