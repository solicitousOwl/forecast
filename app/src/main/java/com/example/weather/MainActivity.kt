package com.example.weather

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.weather.databinding.ActivityMainBinding
import com.example.weather.fragments.MainFragment
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Запуск основного фрагмента экрана
        supportFragmentManager
            .beginTransaction().replace(R.id.placeHolder, MainFragment.newInstance())
            .commit()

    }
}