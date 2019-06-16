package com.example.calorieassistant.main.statistic

import com.example.calorieassistant.models.DishUsed

object Singleton{

    val listDishesSelected = ArrayList<DishUsed>()

    fun getFormula(): Double{
        return (88.362 + (13.397 * 86) + (4.799 * 186) - (5.677 * 23)) * 1.55
    }

    fun getDailyHavka(): Double{
        var poel = 0.0
        for(dish in listDishesSelected){
            poel += dish.getCalories() * dish.weight
        }
        return poel / 100
    }
}