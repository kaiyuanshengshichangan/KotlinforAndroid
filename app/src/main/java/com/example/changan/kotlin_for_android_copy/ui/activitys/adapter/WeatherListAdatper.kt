package com.example.changan.kotlin_for_android_copy.ui.activitys.adapter

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.changan.kotlin_for_android_copy.R
import com.example.changan.kotlin_for_android_copy.domain.models.ForecastList
import com.example.changan.kotlin_for_android_copy.domain.models.ForecastTr
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

/**
 * 天气列表item
 */
class WeatherListAdatper(val items: ForecastList, val onItemClick: (ForecastTr) -> Unit) : Adapter<WeatherListAdatper.ViewHolder>() {

    override fun getItemCount(): Int = items.size()

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        /*
        * with是一个非常有用的函数,它包含在Kotlin的标准库中。它接收一个对象
        和一个扩展函数作为它的参数,然后使这个对象扩展这个函数。这表示所
        有我们在括号中编写的代码都是作为对象(第一个参数)的一个扩展函
        数,我们可以就像作为this一样使用所有它的public方法和属性。当我们针
        对同一个对象做很多操作的时候这个非常有利于简化代码。
        */
//        with(items.dailyForecastList[p1]) {
//            p0.textView.text = "$date - $description - $high - $low"
//        }
//        with(items[position]) {
//            viewHolder.textView.text = "$date - $description - $high - $low"
//        }
        viewHolder.bindForecast(items[position])
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_forecast, p0, false)
        return ViewHolder(view, onItemClick)
    }

    class ViewHolder(view: View, val itemClick: (ForecastTr) -> Unit) : RecyclerView.ViewHolder(view) {

        private val iconView: ImageView
        private val dateView: TextView
        private val descriptionView: TextView
        private val maxTemperatureView: TextView
        private val minTemperatureView: TextView
        init {
            iconView = view.find(R.id.icon)
            dateView = view.find(R.id.dateText)
            descriptionView = view.find(R.id.descriptionText)
            maxTemperatureView = view.find(R.id.maxTemperature)
            minTemperatureView = view.find(R.id.minTemperature)
        }

        fun bindForecast(forecastTr: ForecastTr) {
            with(forecastTr) {
                Picasso.with(itemView.context).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "${high.toString()}"
                minTemperatureView.text = "${low.toString()}"
                itemView.setOnClickListener { itemClick(forecastTr) }
            }
        }
    }

    /**
     * 增加item点击监听，这里用到了重载操作符operate, 重载了invoke了方法，可以简化代码 a.invoke(i) ==> a(i)
     */
    public interface OnItemClickListener {
        operator fun invoke(forecastTr: ForecastTr)
    }

//    fun setOnClickListener(listener: (View) -> Unit)
}