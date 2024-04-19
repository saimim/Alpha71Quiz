package com.example.alpha71quiz.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.core.content.ContextCompat
import com.example.alpha71quiz.Adapter.QuestionAdapter
import com.example.alpha71quiz.Domain.QuestionModel
import com.example.alpha71quiz.R
import com.example.alpha71quiz.databinding.ActivityQuestionBinding
import com.example.alpha71quiz.databinding.ViewholderQuestionBinding

class QuestionActivity : AppCompatActivity(),QuestionAdapter.score {
    private lateinit var binding: ActivityQuestionBinding
    var position:Int=0
    var receivedList : MutableList<QuestionModel> = mutableListOf()
    var allScore=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val window: Window =this@QuestionActivity.window
        window.statusBarColor= ContextCompat.getColor(this@QuestionActivity, R.color.grey)

        receivedList=intent.getParcelableArrayListExtra<QuestionModel>("lis")!!.toMutableList()

        binding.apply {

        }
    }
private fun loadAnswers(){
    val users:MutableList<String> = mutableListOf()
    users.add(receivedList[position].answer_1.toString())
    users.add(receivedList[position].answer_2.toString())
    users.add(receivedList[position].answer_3.toString())
    users.add(receivedList[position].answer_4.toString())

    if(receivedList[position].clickedAnswer!=null)users.add(receivedList[position].clickedAnswer.toString())

    val questionAdapter by lazy {
        QuestionAdapter(
            receivedList[position].correctAnswer.toString(), users, this
        )
    }

    questionAdapter.differ.submitList(users)
    binding.questionList.apply {
        layoutManager =
    }
   }

    override fun amount(number: Int, clickedAnswer: String) {
        allScore+=number
           receivedList[position].clickedAnswer=clickedAnswer
    }
}