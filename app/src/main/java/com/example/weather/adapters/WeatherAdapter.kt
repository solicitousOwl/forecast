package com.example.weather.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.R
import com.example.weather.databinding.ListItemBinding
import com.squareup.picasso.Picasso

class WeatherAdapter(val listener: Listener?) : ListAdapter<WeatherModel, WeatherAdapter.Holder>(Comparator()) {

    // Хранит ссылки на наши элементы View
    class Holder(view: View, val listener: Listener?) : RecyclerView.ViewHolder(view) {
        // привязываем binding
        val binding = ListItemBinding.bind(view)
        var itemTemp: WeatherModel? = null

        init {
            // подключаем слушатель нажатий
            itemView.setOnClickListener {
                itemTemp?.let { it1 -> listener?.onClick(it1) }
            }
        }

        // заполняем разметку
        fun bind(item: WeatherModel) = with(binding){
            itemTemp = item
            tvDate.text = item.time
            tvConditions.text = item.condition
            tvTemp.text = item.currentTemp.ifEmpty {  "${item.maxTemp}°C/${item.minTemp}°C\"" }
            Picasso.get().load("https:" + item.imageUrl).into(im)
        }
    }

    // сравнивает элементы (списки)
    class Comparator :DiffUtil.ItemCallback<WeatherModel>(){
        // в этой функции сравниваем по уникальному элементу. В Этом приложении такого нет
        override fun areItemsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
            return oldItem == newItem
        }

    }

    // создает элементы по шаблону view в соответствии с переданным списком
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return Holder(view, listener)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

    // итерфейс для обработки нажатия
    interface Listener{
        fun onClick(item: WeatherModel)
    }
}