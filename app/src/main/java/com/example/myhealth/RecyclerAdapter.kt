package com.example.myhealth

import android.os.Build
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class RecyclerAdapter(private val exercises: List<Exercise>, private val onItemClicked: (Exercise) -> Unit) :
    RecyclerView.Adapter<ViewHolder>()
    {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            Log.d("health", "onBindViewHolder : $position")
            val exercise = exercises[position]
            holder.itemView.apply {
                findViewById<TextView>(R.id.exercise_name).text = exercise.name
                findViewById<TextView>(R.id.exercise_muscle).text = exercise.muscle
                setOnClickListener { onItemClicked(exercise) }
            }
        }

        override fun getItemCount(): Int = exercises.size
    }