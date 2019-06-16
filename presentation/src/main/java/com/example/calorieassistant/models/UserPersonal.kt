package com.example.calorieassistant.models

import com.example.calorieassistant.models.error.ValidationUserPersonalError

data class UserPersonal(var height: Double,
                        var weight: Double,
                        var age: Int,
                        var sex: Sex,
                        var activityLevel: UserActivityLevel){

    constructor(): this(0.0, 0.0, 0, Sex.Man, UserActivityLevel.No)

    fun isValid(): ValidationUserPersonalError?{
        if(height == 0.0) return ValidationUserPersonalError.HEIGHT_ZERO
        if(weight == 0.0) return ValidationUserPersonalError.WEIGHT_ZERO
        if(age == 0) return ValidationUserPersonalError.AGE_ZERO
        return null
    }

}