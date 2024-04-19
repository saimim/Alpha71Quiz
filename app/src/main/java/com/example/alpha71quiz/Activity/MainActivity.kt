package com.example.alpha71quiz.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.core.content.ContextCompat
import com.example.alpha71quiz.R
import com.example.alpha71quiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val window:Window=this@MainActivity.window
        window.statusBarColor=ContextCompat.getColor(this@MainActivity, R.color.grey)

        binding.apply {
            bottomMenu.setItemSelected(R.id.Home)
            bottomMenu.setOnItemSelectedListener {
                if(it ==R.id.Board){
                    startActivity(Intent(this@MainActivity, LeaderActivity::class.java))
                }
            }
        }
    }
}