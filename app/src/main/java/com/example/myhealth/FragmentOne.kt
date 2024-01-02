package com.example.myhealth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class FragmentOne: Fragment() {
    private lateinit var recyclerAdapter: RecyclerAdapter
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_one, container, false)
        recyclerView = view.findViewById(R.id.fragment_one_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        loadExercises()
        return view
    }

    private fun loadExercises() {
        RetrofitInstance.ninjasApiService.getExercises().enqueue(object: Callback<List<Exercise>> {
            override fun onResponse(call: Call<List<Exercise>>, response: Response<List<Exercise>>) {
                if (response.isSuccessful) {
                    response.body()?.let { exercises ->
                        recyclerAdapter = RecyclerAdapter(exercises) { exercise ->
                            val intent = Intent(requireContext(), FragmentOneItemActivity::class.java)
                            intent.putExtra("itemExerciseName", exercise.name)
                            intent.putExtra("itemExerciseMuscle", exercise.muscle)
                            intent.putExtra("itemExerciseEquipment", exercise.equipment)
                            intent.putExtra("itemExerciseInstruction", exercise.instructions)
                            startActivity(intent)
                        }
                        recyclerView.adapter = recyclerAdapter
                    }
                } else {
                    Log.e("FragmentOne", "API 호출 실패 : ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<List<Exercise>>, t: Throwable) {
                Log.e("FragmentOne", "API 호출 중 오류 발생: ${t.message}")
            }
        })
    }

    private fun setupRecyclerView(exercises: List<Exercise>) {
        val adapter = RecyclerAdapter(exercises) { exercise ->
            val intent = Intent(requireContext(), FragmentOneItemActivity::class.java)
            intent.putExtra("exerciseId", exercise.name)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }
}