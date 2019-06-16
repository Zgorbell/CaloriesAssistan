package com.example.calorieassistant.sign.up

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import android.arch.lifecycle.ViewModel
import com.example.calorieassistant.App
import com.example.calorieassistant.models.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SignUpViewModel: ViewModel() {
    private lateinit var user: User

    fun setUser(user: User) {
        this.user = user
    }

    fun onButtonSignUpClicked(): LiveData<Boolean> {
        return LiveDataReactiveStreams.fromPublisher(
            App.getInstance().restApi.signUp(user.toRemote())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map {
                    it.token?.let { return@map true }
                    it.error?.let { return@map false }
                    false
                }
                .onErrorReturn {
                    false
                }
                .toFlowable())
    }
}