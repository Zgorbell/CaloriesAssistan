package com.example.calorieassistant.personal

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.calorieassistant.models.Sex
import com.example.calorieassistant.models.UserActivityLevel
import com.example.calorieassistant.models.UserPersonal
import com.example.calorieassistant.models.error.ValidationUserPersonalError

class PersonalInfoRegistrationViewModel: ViewModel(){

    private lateinit var userPersonal: UserPersonal
    val submitData = MutableLiveData<ValidationUserPersonalError?>()

    fun setUserPersonal(userPersonal: UserPersonal){
        this.userPersonal = userPersonal
    }

    fun onHeightChanged(height: Double){
        userPersonal.height = height
    }

    fun onWeightChanged(weight: Double){
        userPersonal.weight = weight
    }

    fun onAgeChanged(age: Int){
        userPersonal.age = age
    }

    fun onUserSexChanged(sex: Sex){
        userPersonal.sex = sex
    }

    fun onUserActivityLevelChanged(activity: UserActivityLevel){
        userPersonal.activityLevel = activity
    }

    fun onButtonSubmitClicked(){
        submitData.value = userPersonal.isValid()
    }

}