package com.example.calorieassistant.models

import com.example.remote.model.User

data class User(var name: String, var password: String){

    fun toRemote(): User = User(name, password)
}