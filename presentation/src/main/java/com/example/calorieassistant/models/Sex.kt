package com.example.calorieassistant.models

enum class Sex {

    Man, Woman;

    companion object{
        fun getAll(): List<Sex>{
            return arrayListOf(Man, Woman)
        }
    }
}