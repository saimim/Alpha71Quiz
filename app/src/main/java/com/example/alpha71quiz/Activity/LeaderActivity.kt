package com.example.alpha71quiz.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.core.content.ContextCompat
import com.example.alpha71quiz.Adapter.LeaderAdapter
import com.example.alpha71quiz.Domain.UserModel
import com.example.alpha71quiz.R
import com.example.alpha71quiz.databinding.ActivityLeaderBinding
import com.example.alpha71quiz.databinding.ViewholderLeadersBinding

class LeaderActivity : AppCompatActivity() {
    lateinit var binding: ActivityLeaderBinding
    private val leaderAdapter by lazy { LeaderAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLeaderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val window: Window =this@LeaderActivity.window
        window.statusBarColor= ContextCompat.getColor(this@LeaderActivity, R.color.grey)


        binding.apply {
            binding.scoreTop1Text.text=loadData().get(0).score.toString()
            binding.scoreTop2Text.text=loadData().get(1).score.toString()
            binding.scoreTop3Text.text=loadData().get(2).score.toString()

        }
    }

    private fun loadData():MutableList<UserModel>{
        val users:MutableList<UserModel> = mutableListOf()
        users.add(UserModel(1,"Mim","person1",4850))
        users.add(UserModel(2,"Karim","person2",4560))
        users.add(UserModel(3,"Aslam","person3",3873))
        users.add(UserModel(4,"Johan","person4",3250))
        users.add(UserModel(5,"Sanjida","person5",3015))
        users.add(UserModel(6,"Malek","person6",2970))
        users.add(UserModel(7,"Ashik","person7",2870))
        users.add(UserModel(8,"Akter","person8",2670))
        users.add(UserModel(9,"Jannatun","person9",3880))
        return users
    }
}