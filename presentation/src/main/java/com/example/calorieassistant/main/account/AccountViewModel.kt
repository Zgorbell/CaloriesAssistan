package com.example.calorieassistant.main.account

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.calorieassistant.models.UserPersonal

class AccountViewModel : ViewModel(){

    val logOutLiveData = MutableLiveData<Boolean>()
    private lateinit var userPersonal: UserPersonal


    fun onLogOutClicked(){
        logOutLiveData.value = true
    }
}