package com.meals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.meals.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val mealsAdapter = MealsAdapter()
    private val mealsViewModel: MealsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mealsViewModel.getMeals()
        setUpObservers()
        setUpRecyclerView()
    }

    private fun setUpObservers() {
        lifecycleScope.launch {
            mealsViewModel.categories.collect {
                mealsAdapter.submitList(it?.categories)
            }
        }
    }

    private fun setUpRecyclerView() {
        binding.categoryRv.apply {
            setHasFixedSize(true)
            adapter = mealsAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}