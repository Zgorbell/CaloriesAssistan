package com.example.calorieassistant.main.chooser

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.calorieassistant.App
import com.example.calorieassistant.main.statistic.Singleton
import com.example.calorieassistant.models.DishUsed
import com.example.remote.model.Dish
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import java.util.concurrent.TimeUnit


class DishChooserViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    val dishesLoaded = MutableLiveData<List<Dish>>()
    val dishesSelected = MutableLiveData<List<DishUsed>>()
    var searchedDish: BehaviorSubject<String> = BehaviorSubject.create()

    init {
        configureSearchDishListener()
    }

    private fun configureSearchDishListener() {
        searchedDish.observeOn(Schedulers.io())
            .debounce(300, TimeUnit.MILLISECONDS)
            .doOnSubscribe {
                compositeDisposable.add(it)
            }
            .flatMapSingle {
                App.getInstance().restApi.getDishes(it)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                dishesLoaded.value = it
            }.subscribe()
    }

    fun onDishSelected(dish: Dish){
        Singleton.listDishesSelected.add(DishUsed(dish))
        dishesSelected.postValue(Singleton.listDishesSelected)
    }

    fun onDishMoreInfoClicked(dish: DishUsed){

    }

    fun onDishRemoveClicked(dish: DishUsed){
        Singleton.listDishesSelected.remove(dish)
        dishesSelected.postValue(Singleton.listDishesSelected)
    }

    fun onButtonSubmitClicked(){

    }


    override fun onCleared() {
        compositeDisposable.dispose()
    }
}