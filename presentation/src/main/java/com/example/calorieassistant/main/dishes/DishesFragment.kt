package com.example.calorieassistant.main.dishes

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.calorieassistant.R
import com.example.calorieassistant.models.Dish
import kotlinx.android.synthetic.main.fragment_dishes_list.*

class DishesFragment: Fragment(){

    private lateinit var adapter: ListAdapter<Dish, DishesListAdapter.DishesViewHolder>
    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dishes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRecycler()
        setupFragmentController()
    }

    private fun setupFragmentController(){
        navController = Navigation.findNavController(fragment_dishes_recycler_view)
    }

    private fun setupRecycler(){
        fragment_dishes_recycler_view.layoutManager = LinearLayoutManager(requireContext())
        DishesListAdapter { onDishClicked(it)}.let {
            adapter = it
            fragment_dishes_recycler_view.adapter = it
        }
        adapter.submitList(getDishes())
    }

    private fun onDishClicked(dish: Dish){
        navController.navigate(R.id.dishFragment)
    }

    private fun getDishes(): MutableList<Dish>{
        val dishes = ArrayList<Dish>()
        dishes.add(Dish(0, "Курица запеченая в духовке ", 400.toDouble()))
        dishes.add(Dish(1, "Стейк на гриле", 390.toDouble()))
        dishes.add(Dish(2, "Свинная отбивная", 400.toDouble()))
        dishes.add(Dish(3, "Гуляш из индейки", 400.toDouble()))
        dishes.add(Dish(4, "Колбаса домашняя из свинины", 400.toDouble()))
        return dishes
    }
}