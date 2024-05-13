package com.example.weather.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

// Создание адаптера для Переключение фрагментов в таблаяутах с помощью viewPager
class VpAdapter(fa: FragmentActivity, private val list: List<Fragment>) : FragmentStateAdapter(fa) {
    // получаем количество фрагментов
    override fun getItemCount(): Int {
        return list.size
    }
    // выбираем нужный фрагмент
    override fun createFragment(position: Int): Fragment {
        return list[position]
    }
}