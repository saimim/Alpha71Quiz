package com.example.alpha71quiz.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.alpha71quiz.Domain.QuestionModel
import com.example.alpha71quiz.Domain.UserModel
import com.example.alpha71quiz.R
import com.example.alpha71quiz.databinding.ViewholderQuestionBinding

class QuestionAdapter(
    val correctAnswer: String,
    val user:MutableList<String> = mutableListOf(),
    var returnScore:score
) :RecyclerView.Adapter<QuestionAdapter.Viewholder>(){

    interface score{
        fun amount(number: Int,clickedAnswer:String)
    }


    private lateinit var binding:ViewholderQuestionBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionAdapter.Viewholder {
        val inflater=LayoutInflater.from(parent.context)
        binding=ViewholderQuestionBinding.inflate(inflater,parent,false)
        return Viewholder()
    }

    override fun onBindViewHolder(holder: QuestionAdapter.Viewholder, position: Int) {
       val binding = ViewholderQuestionBinding.bind(holder.itemView)
        binding.answerTxt.text=differ.currentList[position]
        var currentPos=0
        when(correctAnswer){
            "a"->{
                currentPos=0
            }
            "b"->{
                currentPos=1
            }
            "c"->{
                currentPos=2
            }
            "d"->{
                currentPos=3
            }
        }
        if(differ.currentList.size==5 && currentPos==position){
            binding.answerTxt.setBackgroundResource(R.drawable.green_background)
            binding.answerTxt.setTextColor(ContextCompat.getColor(binding.root.context,R.color.white))
            val drawable=ContextCompat.getDrawable(binding.root.context,R.drawable.tick)
            binding.answerTxt.setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,drawable,null)
        }



    }

    override fun getItemCount()=differ.currentList.size

    inner class Viewholder:RecyclerView.ViewHolder(binding.root)

    private val differCallback=object : DiffUtil.ItemCallback<String>(){
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem==newItem
        }
    }

    val differ= AsyncListDiffer(this,differCallback)
}