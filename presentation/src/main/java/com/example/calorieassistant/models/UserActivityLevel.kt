package com.example.calorieassistant.models

enum class UserActivityLevel{
    No, Low, Medium, High, Extreme;

    companion object{
        fun getAll(): List<UserActivityLevel>{
            return arrayListOf(No, Low, Medium, High, Extreme)
        }
    }

}