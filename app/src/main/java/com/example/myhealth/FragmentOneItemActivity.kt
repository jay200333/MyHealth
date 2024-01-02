package com.example.myhealth

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FragmentOneItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_one_item)

        val exerciseName = intent.getStringExtra("itemExerciseName")
        val exerciseNameTextView: TextView = findViewById(R.id.item_exercise_name)
        exerciseNameTextView.text = "$exerciseName"

        val exerciseMuscle = intent.getStringExtra("itemExerciseMuscle")
        val exerciseMuscleTextView: TextView = findViewById(R.id.item_exercise_muscle)
        exerciseMuscleTextView.text = "집중 영역 $exerciseMuscle"

        val exerciseEquipment = intent.getStringExtra("itemExerciseEquipment")
        val exerciseEquipmentTextView: TextView = findViewById(R.id.item_exercise_equipment)
        exerciseEquipmentTextView.text = "장비 $exerciseEquipment"

        val exerciseInstruction = intent.getStringExtra("itemExerciseInstruction")
        val exerciseInfoTextView: TextView = findViewById(R.id.item_exercise_instruction)
        exerciseInfoTextView.text = "운동 설명: $exerciseInstruction"

        val completeButton: Button = findViewById(R.id.item_complete_button)
        completeButton.setOnClickListener {
            finish()
        }
    }
}