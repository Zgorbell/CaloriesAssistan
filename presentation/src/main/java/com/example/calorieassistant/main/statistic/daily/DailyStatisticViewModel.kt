package com.example.calorieassistant.main.statistic.daily

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.view.View
import com.example.calorieassistant.models.Dish
import com.example.calorieassistant.models.DishUsed
import io.reactivex.Completable
import io.reactivex.subjects.PublishSubject

class DailyStatisticViewModel : ViewModel(){

    val addDishLiveData = MutableLiveData<Boolean>()

    fun onDishClicked(dish: DishUsed){

    }

    fun onAddDishClicked(){
        addDishLiveData.value = true
        addDishLiveData.value = false
    }

    override fun onCleared() {
        super.onCleared()
    }
}